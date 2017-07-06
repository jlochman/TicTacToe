package cz.jkoudelka.tictactoe.graphics.layout;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.graphics.content.GamePaneController;
import cz.jkoudelka.tictactoe.graphics.content.InfoPaneController;
import cz.jkoudelka.tictactoe.graphics.game.GameListViewController;
import cz.jkoudelka.tictactoe.graphics.player.PlayerListViewController;
import cz.jkoudelka.tictactoe.observer.Event;
import cz.jkoudelka.tictactoe.observer.Observer;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.GameEndedEvent;
import cz.jkoudelka.tictactoe.utils.DialogUtils;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class StandardLayoutController implements Initializable {

	@FXML
	private AnchorPane playerLWPane;
	@FXML
	private AnchorPane gameLWPane;
	@FXML
	private AnchorPane infoPane;
	@FXML
	private AnchorPane gamePane;

	ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();

	public void initialize(URL location, ResourceBundle resources) {
		GraphicControllerDTO gcDTO;

		gcDTO = PaneUtils.loadFXPaneByClass(PlayerListViewController.class);
		PaneUtils.insertPaneToContent(gcDTO.getGraphic(), playerLWPane);

		gcDTO = PaneUtils.loadFXPaneByClass(GameListViewController.class);
		PaneUtils.insertPaneToContent(gcDTO.getGraphic(), gameLWPane);

		gcDTO = PaneUtils.loadFXPaneByClass(InfoPaneController.class);
		PaneUtils.insertPaneToContent(gcDTO.getGraphic(), infoPane);

		gcDTO = PaneUtils.loadFXPaneByClass(GamePaneController.class);
		PaneUtils.insertPaneToContent(gcDTO.getGraphic(), gamePane);

		observerManager.registerObserver(new Observer() {

			@Override
			public void processEvent(Event event) {
				if (event instanceof GameEndedEvent) {
					GameEndedEvent typedEvent = (GameEndedEvent) event;
					String msg = "";
					switch (typedEvent.getGameResult()) {
					case PLAYER_WINS:
						msg = "Player Wins";
						break;
					case CPU_WINS:
						msg = "CPU Wins";
						break;
					case SPLIT:
						msg = "Split";
						break;
					default:
						break;
					}
					Alert alert = DialogUtils.buildAlertDialog("GameEnded", "GameEnded", msg, AlertType.INFORMATION);
					alert.showAndWait();
				}

			}
		});
	}

}
