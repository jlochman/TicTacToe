package cz.jkoudelka.tictactoe.graphics.player;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PlayerListViewController implements Initializable {

	@FXML
	private ListView<PlayerEntity> playerLW;
	@FXML
	private Button btnAddPlayer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
