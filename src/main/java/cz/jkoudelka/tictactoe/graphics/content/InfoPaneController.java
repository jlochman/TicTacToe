package cz.jkoudelka.tictactoe.graphics.content;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;
import cz.jkoudelka.tictactoe.gameInstance.Board;
import cz.jkoudelka.tictactoe.gameInstance.Board.BoardTile;
import cz.jkoudelka.tictactoe.gameInstance.GameInstance;
import cz.jkoudelka.tictactoe.observer.Event;
import cz.jkoudelka.tictactoe.observer.Observer;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.GameSelectedEvent;
import cz.jkoudelka.tictactoe.observer.events.PlayerSelectedEvent;
import cz.jkoudelka.tictactoe.observer.events.SomeonePlayedEvent;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 * Zalozka obsahujici hlavni informace o hre.
 * 
 * @author jlochman
 *
 */
public class InfoPaneController implements Initializable {

	@FXML
	private Label lblInitiator;
	@FXML
	private Label lblPlayerSymbol;
	@FXML
	private Label lblCPUSymbol;
	@FXML
	private Label lblCPULogic;
	@FXML
	private Label lblResult;

	@FXML
	private AnchorPane paneHistory;

	private final static int SMALL_CELL_SIZE = 20;
	private final static int BIG_CELL_SIZE = 100;

	ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();
	GameEntityService gameEntityService = ServiceLocator.getInstance().getGameEntityService();

	/**
	 * Registrace observeru na {@link GameSelectedEvent},
	 * {@link SomeonePlayedEvent} a {@link PlayerSelectedEvent}
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		clear();

		observerManager.registerObserver(new Observer() {

			@Override
			public void processEvent(Event event) {
				if (event instanceof GameSelectedEvent) {
					GameSelectedEvent typedEvent = (GameSelectedEvent) event;
					fillInfo(typedEvent.getGameEntity());
				} else if (event instanceof SomeonePlayedEvent) {
					SomeonePlayedEvent typedEvent = (SomeonePlayedEvent) event;
					fillInfo(typedEvent.getGameEntity());
				} else if (event instanceof PlayerSelectedEvent) {
					clear();
				}
			}
		});

	}

	/**
	 * vyplneni informaci pro danou gameEntity.
	 * 
	 * @param gameEntity
	 */
	private void fillInfo(GameEntity gameEntity) {
		if (gameEntity == null) {
			clear();
			return;
		}

		lblInitiator.setText(gameEntity.getInitiator().name());
		lblPlayerSymbol.setText(gameEntity.getPlayerSymbol().toString());
		lblCPUSymbol.setText(gameEntity.getCpuSymbol().toString());
		lblCPULogic.setText(gameEntity.getCpuLogic().name());
		lblResult.setText(gameEntity.getResult().name());

		fillHistoryPane(gameEntity);
	}

	/**
	 * vykresleni historie hry. Hlavni GridPane (3x3), ktera postupne,
	 * zleva-doprava, odshora-dolu vykresluje do svych poli stav {@link Board}.
	 * 
	 * @param gameEntity
	 */
	private void fillHistoryPane(GameEntity gameEntity) {
		String playerSymbol = gameEntity.getPlayerSymbol().toString();
		String cpuSymbol = gameEntity.getCpuSymbol().toString();
		GameInstance gameInstance = gameEntityService.getGameInstance(gameEntity);

		GridPane gridPane = new GridPane();
		List<Board> boards = gameInstance.getBoards();
		int row = 0;
		int col = 0;
		for (int i = 0; i < boards.size(); i++) {
			col = i % 3;
			row = i / 3;
			gridPane.add(getBoardPane(boards.get(i), playerSymbol, cpuSymbol), col, row);
		}

		// nastaveni gridPane, aby zobrazovala pekne
		ColumnConstraints cc = new ColumnConstraints(BIG_CELL_SIZE, BIG_CELL_SIZE, BIG_CELL_SIZE);
		RowConstraints rc = new RowConstraints(BIG_CELL_SIZE, BIG_CELL_SIZE, BIG_CELL_SIZE);
		gridPane.getColumnConstraints().addAll(cc, cc, cc);
		gridPane.getRowConstraints().addAll(rc, rc, rc);
		for (Node child : gridPane.getChildren()) {
			GridPane.setHalignment(child, HPos.CENTER);
			GridPane.setValignment(child, VPos.CENTER);
		}
		PaneUtils.insertPaneToContent(gridPane, paneHistory);
	}

	/**
	 * Vykresleni jedne {@link Board} do GridPane (3x3).
	 * 
	 * @param board
	 * @param playerSymbol
	 * @param cpuSymbol
	 * @return
	 */
	private Pane getBoardPane(Board board, String playerSymbol, String cpuSymbol) {
		GridPane gridPane = new GridPane();
		gridPane.setGridLinesVisible(true);
		for (int row = 0; row < Board.ROWS; row++) {
			for (int col = 0; col < Board.COLS; col++) {
				BoardTile tile = board.getTile(row, col);
				switch (tile) {
				case CPU:
					gridPane.add(new Label(cpuSymbol), col, row);
					break;
				case PLAYER:
					gridPane.add(new Label(playerSymbol), col, row);
					break;
				case EMTPY:
					gridPane.add(new Label(), col, row);
				}
			}
		}

		// nastaveni gridPane, aby zobrazovala pekne
		ColumnConstraints cc = new ColumnConstraints(SMALL_CELL_SIZE, SMALL_CELL_SIZE, SMALL_CELL_SIZE);
		RowConstraints rc = new RowConstraints(SMALL_CELL_SIZE, SMALL_CELL_SIZE, SMALL_CELL_SIZE);
		gridPane.getColumnConstraints().addAll(cc, cc, cc);
		gridPane.getRowConstraints().addAll(rc, rc, rc);
		for (Node child : gridPane.getChildren()) {
			GridPane.setHalignment(child, HPos.CENTER);
			GridPane.setValignment(child, VPos.CENTER);
		}
		return gridPane;
	}

	private void clear() {
		lblInitiator.setText("");
		lblPlayerSymbol.setText("");
		lblCPUSymbol.setText("");
		lblCPULogic.setText("");
		lblResult.setText("");

		paneHistory.getChildren().clear();
	}

}
