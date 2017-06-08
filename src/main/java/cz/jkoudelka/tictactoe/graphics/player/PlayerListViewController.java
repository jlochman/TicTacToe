package cz.jkoudelka.tictactoe.graphics.player;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.observer.Event;
import cz.jkoudelka.tictactoe.observer.Observer;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.PlayerCreatedEvent;
import cz.jkoudelka.tictactoe.utils.DialogUtils;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PlayerListViewController implements Initializable {

	@FXML
	private ListView<PlayerEntity> playerLW;
	@FXML
	private Button btnAddPlayer;

	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		observerManager.registerObserver(new Observer() {

			@Override
			public void processEvent(Event event) {
				if (event instanceof PlayerCreatedEvent) {
					PlayerCreatedEvent typedEvent = (PlayerCreatedEvent) event;
					System.out.println(typedEvent.getPlayer().getId());
				}
			}
		});

		btnAddPlayer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GraphicControllerDTO gcDTO = PaneUtils.loadFXPaneByClass(PlayerFormController.class);
				PlayerFormController controller = (PlayerFormController) gcDTO.getController();
				controller.init(new PlayerEntity());
				DialogUtils.buildDialog(gcDTO.getGraphic());
			}
		});
	}

}
