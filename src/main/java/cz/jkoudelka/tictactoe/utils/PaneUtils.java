package cz.jkoudelka.tictactoe.utils;

import java.io.IOException;
import java.net.URL;

import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PaneUtils {

	public static void insertPaneToContent(Pane pane, Pane contentPane) {
		AnchorPane.setLeftAnchor(pane, 0.);
		AnchorPane.setRightAnchor(pane, 0.);
		AnchorPane.setBottomAnchor(pane, 0.);
		AnchorPane.setTopAnchor(pane, 0.);

		contentPane.getChildren().clear();
		contentPane.getChildren().setAll(pane);
	}

	public static GraphicControllerDTO loadFXPaneByName(URL url) {
		FXMLLoader loader = new FXMLLoader(url);
		try {
			AnchorPane pane = loader.load();
			Object controller = loader.getController();
			return new GraphicControllerDTO(controller, pane);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static GraphicControllerDTO loadFXPaneByClass(Class<? extends Initializable> controllerClazz) {
		String fxmlFileName = controllerClazz.getSimpleName().replaceAll("Controller", ".fxml");
		return loadFXPaneByName(controllerClazz.getResource(fxmlFileName));
	}

}
