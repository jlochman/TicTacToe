package cz.jkoudelka.tictactoe.graphics.game;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;
import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.observer.Event;
import cz.jkoudelka.tictactoe.observer.Observer;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.GameCreatedEvent;
import cz.jkoudelka.tictactoe.observer.events.GameSelectedEvent;
import cz.jkoudelka.tictactoe.observer.events.PlayerSelectedEvent;
import cz.jkoudelka.tictactoe.utils.DialogUtils;
import cz.jkoudelka.tictactoe.utils.ListViewUtils;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class GameListViewController implements Initializable {

	@FXML
	private ListView<GameEntity> gameLW;
	@FXML
	private Button btnNewGame;

	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();
	private PlayerEntityService playerEntityService = ServiceLocator.getInstance().getPlayerEntityService();

	private PlayerEntity selectedPlayer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ListViewUtils.setTextFactory(gameLW, this::gameToString);
		ListViewUtils.setNewItemSelectedListener(gameLW, this::gameSelectedEvent);
		btnNewGame.setOnAction(this::newGamePressed);

		fillData();

		observerManager.registerObserver(new Observer() {

			@Override
			public void processEvent(Event event) {
				if (event instanceof GameCreatedEvent) {
					GameCreatedEvent typedEvent = (GameCreatedEvent) event;
					selectedPlayer = playerEntityService.refresh(selectedPlayer);
					fillData();
					ListViewUtils.selectByID(gameLW, typedEvent.getGame());
				} else if (event instanceof PlayerSelectedEvent) {
					PlayerSelectedEvent typedEvent = (PlayerSelectedEvent) event;
					selectedPlayer = typedEvent.getPlayer();
					fillData();
				}

			}
		});

	}

	private void fillData() {
		if (selectedPlayer == null) {
			return;
		}
		gameLW.getItems().clear();
		gameLW.getItems().addAll(selectedPlayer.getGames());
	}

	private String gameToString(GameEntity game) {
		return "[" + game.getId() + "] " + game.getCpuLogic() + " " + game.getResult();
	}

	private void gameSelectedEvent(GameEntity game) {
		observerManager.raiseEvent(new GameSelectedEvent(game));
	}

	private void newGamePressed(ActionEvent event) {
		GraphicControllerDTO gcDTO = PaneUtils.loadFXPaneByClass(GameFormController.class);
		GameFormController controller = (GameFormController) gcDTO.getController();

		GameEntity formGame = new GameEntity();
		formGame.setPlayer(selectedPlayer);
		controller.init(formGame);

		DialogUtils.buildDialog(gcDTO.getGraphic());
	}

}
