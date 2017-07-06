package cz.jkoudelka.tictactoe.app;

import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import cz.jkoudelka.tictactoe.graphics.layout.StandardLayoutController;
import cz.jkoudelka.tictactoe.utils.PaneUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Touto tridou se cela aplikace spousti. Jedna se o JavaFX aplikaci, pri startu
 * se nejprve inicializuji DAO, nasledne servicy a na zaver je spustena sama
 * graficka aplikace.
 * 
 * @author jlochman
 *
 */
public class App extends Application {

	/**
	 * Tuto metodu vola JavaFX. Do primaryStage se vlozi grafika obsazena ve
	 * StandardLayoutControlleru.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		GraphicControllerDTO gcDTO = PaneUtils.loadFXPaneByClass(StandardLayoutController.class);
		Scene scene = new Scene(gcDTO.getGraphic(), 1000, 600);

		primaryStage.setTitle("TIC TAC TOE");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * jediny main cele aplikace. Inicializuje DAO, Servicy a pote spusti
	 * grafiku
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DAOLocator.getInstance().initializeDAOs();
		ServiceLocator.getInstance().initializeService();

		App.launch(args);
	}

}
