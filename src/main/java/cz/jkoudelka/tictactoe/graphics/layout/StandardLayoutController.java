package cz.jkoudelka.tictactoe.graphics.layout;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.graphics.content.GamePaneController;
import cz.jkoudelka.tictactoe.graphics.content.InfoPaneController;
import cz.jkoudelka.tictactoe.graphics.game.GameListViewController;
import cz.jkoudelka.tictactoe.graphics.player.PlayerListViewController;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	}

}
