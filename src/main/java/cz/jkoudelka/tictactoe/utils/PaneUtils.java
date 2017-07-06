package cz.jkoudelka.tictactoe.utils;

import java.io.IOException;
import java.net.URL;

import cz.jkoudelka.tictactoe.graphics.common.GraphicControllerDTO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * Metody pro nacitani grafiky a a skladani grafiky z dilcich casti.
 * 
 * @author jlochman
 *
 */
public class PaneUtils {

	/**
	 * Vlozeni {@link Pane} do jine {@link Pane}
	 * 
	 * @param pane
	 * @param contentPane
	 */
	public static void insertPaneToContent(Pane pane, Pane contentPane) {
		AnchorPane.setLeftAnchor(pane, 0.);
		AnchorPane.setRightAnchor(pane, 0.);
		AnchorPane.setBottomAnchor(pane, 0.);
		AnchorPane.setTopAnchor(pane, 0.);

		contentPane.getChildren().clear();
		contentPane.getChildren().setAll(pane);
	}

	/**
	 * Ziska {@link GraphicControllerDTO} pro dane URL. Pri nacteni se ziska
	 * jednak grafika, jednak controller pro tuto grafiku. Oba tyto objekty se
	 * zaobali do tridy {@link GraphicControllerDTO}.
	 * 
	 * @param url
	 * @return
	 */
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

	/**
	 * V aplikaci pouzivam konvenci pro pojmenovani grafiky a jejiho
	 * controlleru: Vzdy je vkladam do stejneho balicku a kdyz grafika je
	 * pojmenovana Grafika.fxml, pak controller se jmenume
	 * GrafikaController.java. Teto metodu staci predat tridu
	 * GrafikaContoller.class
	 * 
	 * @param controllerClazz
	 * @return
	 */
	public static GraphicControllerDTO loadFXPaneByClass(Class<? extends Initializable> controllerClazz) {
		String fxmlFileName = controllerClazz.getSimpleName().replaceAll("Controller", ".fxml");
		return loadFXPaneByName(controllerClazz.getResource(fxmlFileName));
	}

}
