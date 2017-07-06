package cz.jkoudelka.tictactoe.graphics.content;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.cpu.CPULogicInstance;
import cz.jkoudelka.tictactoe.cpu.Coordinates;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;
import cz.jkoudelka.tictactoe.game.Board;
import cz.jkoudelka.tictactoe.game.Board.BoardTile;
import cz.jkoudelka.tictactoe.game.GameInstance;
import cz.jkoudelka.tictactoe.game.GameInstanceService;
import cz.jkoudelka.tictactoe.observer.Event;
import cz.jkoudelka.tictactoe.observer.Observer;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.GameEndedEvent;
import cz.jkoudelka.tictactoe.observer.events.GameSelectedEvent;
import cz.jkoudelka.tictactoe.observer.events.PlayerSelectedEvent;
import cz.jkoudelka.tictactoe.observer.events.SomeonePlayedEvent;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class GamePaneController implements Initializable {

	@FXML
	private HBox hBox;
	@FXML
	private AnchorPane gamePane;

	private GameEntity gameEntity;
	private GameInstance gameInstance;
	private CPULogicInstance cpuLogic;

	private final static int TILE_SIZE = 50;

	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();
	private GameEntityService gameEntityService = ServiceLocator.getInstance().getGameEntityService();
	private GameInstanceService gameInstanceService = ServiceLocator.getInstance().getGameInstanceService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		clear();

		observerManager.registerObserver(new Observer() {

			@Override
			public void processEvent(Event event) {
				if (event instanceof GameSelectedEvent) {
					GameSelectedEvent typedEvent = (GameSelectedEvent) event;
					init(typedEvent.getGameEntity());
				} else if (event instanceof PlayerSelectedEvent) {
					clear();
				}

			}
		});

	}

	public void init(GameEntity gameEntity) {
		if (gameEntity == null) {
			clear();
			return;
		}

		this.gameEntity = gameEntity;
		gameInstance = gameEntityService.getGameInstance(gameEntity);
		try {
			cpuLogic = gameEntity.getCpuLogic().getLogicClazz().newInstance();
		} catch (InstantiationException e) {
			gameEntityService.error(gameEntity, "cpu logic was not initialized: " + cpuLogic.getClass().getName());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			gameEntityService.error(gameEntity, "illegal access to cpu logic: " + cpuLogic.getClass().getName());
			e.printStackTrace();
		}

		Board lastBoard = gameInstanceService.getLastBoard(gameInstance);
		if (lastBoard == null) {
			displayBoard(new Board());
		} else {
			displayBoard(lastBoard);
		}
	}

	public void clear() {
		gamePane.getChildren().clear();
	}

	public void displayBoard(Board board) {
		GridPane gridPane = new GridPane();
		gridPane.setGridLinesVisible(true);
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				BoardTile tile = board.getTile(row, col);
				switch (tile) {
				case CPU:
					gridPane.add(new Label(gameEntity.getCpuSymbol().toString()), col, row);
					break;
				case PLAYER:
					gridPane.add(new Label(gameEntity.getPlayerSymbol().toString()), col, row);
					break;
				case EMTPY:
					if (gameEntity.getResult() == GameResult.DNF) {
						Button btn = new Button();
						btn.setPrefSize(TILE_SIZE, TILE_SIZE);
						final int finalRow = row;
						final int finalCol = col;
						btn.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								play(finalRow, finalCol);
							}
						});
						gridPane.add(btn, col, row);
						break;
					}
				}
			}
		}
		
		ColumnConstraints cc = new ColumnConstraints(TILE_SIZE, TILE_SIZE, TILE_SIZE);
		RowConstraints rc = new RowConstraints(TILE_SIZE, TILE_SIZE, TILE_SIZE);
		gridPane.getColumnConstraints().addAll(cc, cc, cc);
		gridPane.getRowConstraints().addAll(rc, rc, rc);
		for (Node child : gridPane.getChildren()) {
			GridPane.setHalignment(child, HPos.CENTER);
			GridPane.setValignment(child, VPos.CENTER);
		}
		
		PaneUtils.insertPaneToContent(gridPane, gamePane);
	}

	private void play(int row, int col) {
		gameInstanceService.playPlayer(gameInstance, row, col);
		gameEntityService.info(gameEntity, "player played [" + row + "," + col + "]");

		GameResult result = gameInstanceService.checkResult(gameInstance);
		switch (result) {
		case PLAYER_WINS:
			gameEntity.setResult(GameResult.PLAYER_WINS);
			gameEntityService.info(gameEntity, "game ended: player wins");
			observerManager.raiseEvent(new GameEndedEvent(gameEntity, GameResult.PLAYER_WINS));
			break;
		case SPLIT:
			gameEntity.setResult(GameResult.SPLIT);
			gameEntityService.info(gameEntity, "game ended: split");
			observerManager.raiseEvent(new GameEndedEvent(gameEntity, GameResult.SPLIT));
		default:
			break;
		}
		gameEntityService.setGameInstance(gameEntity, gameInstance);
		gameEntityService.update(gameEntity);
		observerManager.raiseEvent(new SomeonePlayedEvent(gameEntity));
		displayBoard(gameInstanceService.getLastBoard(gameInstance));

		if (gameEntity.getResult() != GameResult.DNF) {
			return;
		}
		Coordinates coord = cpuLogic.play(gameInstanceService.getLastBoard(gameInstance));
		gameInstanceService.playCPU(gameInstance, coord.getRow(), coord.getCol());
		gameEntityService.info(gameEntity, "cpu played [" + row + "," + col + "]");

		result = gameInstanceService.checkResult(gameInstance);
		switch (result) {
		case CPU_WINS:
			gameEntity.setResult(GameResult.CPU_WINS);
			gameEntityService.info(gameEntity, "game ended: cpu wins");
			observerManager.raiseEvent(new GameEndedEvent(gameEntity, GameResult.CPU_WINS));
			break;
		case SPLIT:
			gameEntity.setResult(GameResult.SPLIT);
			gameEntityService.info(gameEntity, "game ended: split");
			observerManager.raiseEvent(new GameEndedEvent(gameEntity, GameResult.SPLIT));
		default:
			break;
		}
		gameEntityService.setGameInstance(gameEntity, gameInstance);
		gameEntityService.update(gameEntity);
		observerManager.raiseEvent(new SomeonePlayedEvent(gameEntity));
		displayBoard(gameInstanceService.getLastBoard(gameInstance));
	}

}
