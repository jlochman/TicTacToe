package cz.jkoudelka.tictactoe.graphics.player;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.PlayerCreatedEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Formular pro zadavani noveho hrace.
 * 
 * @author jlochman
 *
 */
public class PlayerFormController implements Initializable {

	@FXML
	private Button btnCreate;
	@FXML
	private TextField edtName;
	@FXML
	private TextField edtPwd;

	private PlayerEntityService playerEntityService = ServiceLocator.getInstance().getPlayerEntityService();
	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();

	private PlayerEntity playerEntity;

	/**
	 * Nastaveni prislusne akce, co se ma stat, kdyz tlacitko Create je
	 * zmacknuto.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnCreate.setOnAction(this::createPlayerPressed);
	}

	public void init(PlayerEntity playerEntity) {
		if (playerEntity == null) {
			return;
		}
		this.playerEntity = playerEntity;

		edtName.setText(playerEntity.getName());
		edtPwd.setText(playerEntity.getPwd());
	}

	private void closeWindow() {
		Stage stage = (Stage) btnCreate.getScene().getWindow();
		stage.close();
	}

	/**
	 * Hodnoty z poli se prekopiruji na {@link PlayerEntity} a ta se nasledne
	 * ulozi.
	 * 
	 * @param event
	 */
	private void createPlayerPressed(ActionEvent event) {
		if (playerEntity == null) {
			return;
		}
		playerEntity.setName(edtName.getText());
		playerEntity.setPwd(edtPwd.getText());
		playerEntityService.persist(playerEntity);
		playerEntityService.info(playerEntity, "player created");
		observerManager.raiseEvent(new PlayerCreatedEvent(playerEntity));
		closeWindow();
	}

}
