package cz.jkoudelka.tictactoe.graphics.player;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerEntityService;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.PlayerCreatedEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerFormController implements Initializable {

	@FXML
	private Button btnCreate;
	@FXML
	private TextField edtName;
	@FXML
	private TextField edtPwd;

	private PlayerEntityService playerEntityService = ServiceLocator.getInstance().getPlayerEntityService();
	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();

	private PlayerEntity player;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnCreate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.setName(edtName.getText());
				player.setPwd(edtPwd.getText());
				playerEntityService.persist(player);
				observerManager.raiseEvent(new PlayerCreatedEvent(player));
				closeWindow();
			}
		});
	}

	public void init(PlayerEntity player) {
		this.player = player;

		edtName.setText(player.getName());
		edtPwd.setText(player.getPwd());
	}

	private void closeWindow() {
		Stage stage = (Stage) btnCreate.getScene().getWindow();
		stage.close();
	}

}
