package cz.jkoudelka.tictactoe.graphics.player;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;
import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.observer.Event;
import cz.jkoudelka.tictactoe.observer.Observer;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.PlayerCreatedEvent;
import cz.jkoudelka.tictactoe.observer.events.PlayerSelectedEvent;
import cz.jkoudelka.tictactoe.utils.DialogUtils;
import cz.jkoudelka.tictactoe.utils.ListViewUtils;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Controller obsahujici {@link ListView} zobrazujici vsechny hrace.
 * 
 * @author jlochman
 *
 */
public class PlayerListViewController implements Initializable {

	@FXML
	private ListView<PlayerEntity> playerLW;
	@FXML
	private Button btnAddPlayer;

	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();
	private PlayerEntityService playerEntityService = ServiceLocator.getInstance().getPlayerEntityService();

	/**
	 * Pri inicializaci se nastavi, jak se ma hrac zobrazit, co se ma stat pri
	 * vyberu hrace a akce na tlacitko. Po vyplneni dat se registruje observer,
	 * naslouchajici na udalost, kdy je vytvoren novy hrac.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ListViewUtils.setTextFactory(playerLW, this::playerToString);
		ListViewUtils.setNewItemSelectedListener(playerLW, this::playerSelectedEvent);
		btnAddPlayer.setOnAction(this::addPlayerPressed);

		fillData();

		observerManager.registerObserver(new Observer() {
			@Override
			public void processEvent(Event event) {
				if (event instanceof PlayerCreatedEvent) {
					PlayerCreatedEvent typedEvent = (PlayerCreatedEvent) event;
					fillData();
					ListViewUtils.selectByID(playerLW, typedEvent.getPlayerEntity());
				}
			}
		});

	}

	private void fillData() {
		playerLW.getItems().clear();
		playerLW.getItems().addAll(playerEntityService.findAll());
	}

	private String playerToString(PlayerEntity player) {
		return "[" + player.getId() + "] " + player.getName();
	}

	private void playerSelectedEvent(PlayerEntity player) {
		if (player == null) {
			return;
		}
		player = playerEntityService.refresh(player);
		observerManager.raiseEvent(new PlayerSelectedEvent(player));
	}

	/**
	 * Pokud je stisknuto tlacitko PridatHrace, pripravi se patricny formular a
	 * inicializuje se novym hracem.
	 * 
	 * @param event
	 */
	private void addPlayerPressed(ActionEvent event) {
		GraphicControllerDTO gcDTO = PaneUtils.loadFXPaneByClass(PlayerFormController.class);
		PlayerFormController controller = (PlayerFormController) gcDTO.getController();
		controller.init(new PlayerEntity());
		DialogUtils.buildDialog(gcDTO.getGraphic());
	}

}
