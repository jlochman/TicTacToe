package cz.jkoudelka.tictactoe.graphics.game;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class GameListViewController implements Initializable {

	@FXML
	private ListView<GameEntity> gameLW;
	@FXML
	private Button btnNewGame;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
