package cz.jkoudelka.tictactoe.app;

import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.graphics.layout.StandardLayoutController;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GraphicControllerDTO gcDTO = PaneUtils.loadFXPaneByClass(StandardLayoutController.class);
		Scene scene = new Scene(gcDTO.getGraphic(), 400, 300);

		primaryStage.setTitle("TIC TAC TOE");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		ServiceLocator.getInstance().initializeService();
		App.launch(args);
	}

}
