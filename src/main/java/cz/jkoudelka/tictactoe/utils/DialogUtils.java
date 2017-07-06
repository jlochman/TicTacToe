package cz.jkoudelka.tictactoe.utils;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Vytvareni dialogu (vyskakovacich oken).
 * 
 * @author jlochman
 *
 */
public class DialogUtils {

	/**
	 * Vytvoreni dialogu s vlastni grafikou.
	 * 
	 * @param contentPane
	 *            grafika
	 * @param width
	 *            preferovana sirka
	 * @param height
	 *            preferovana vyska
	 */
	public static void buildDialog(Pane contentPane, double width, double height) {
		Scene scene;
		if (contentPane.getScene() != null) {
			scene = contentPane.getScene();
		} else {
			scene = new Scene(contentPane, width, height);
		}

		Stage dialog = new Stage();
		dialog.setTitle("dialog");
		dialog.setHeight(height);
		dialog.setWidth(width);
		dialog.setScene(scene);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.showAndWait();
	}

	/**
	 * Vytvoreni dialogu s vyskou a sirkou urcenou podle preferovana vysky a
	 * sirky predane grafiky
	 * 
	 * @param contentPane
	 *            grafika
	 */
	public static void buildDialog(Pane contentPane) {
		buildDialog(contentPane, contentPane.getPrefWidth(), contentPane.getPrefHeight());
	}

	/**
	 * Vytvoreni obecneho dialogu. Nasledne je treba volat metodu tridy
	 * {@link Alert} showAndWait();
	 * 
	 * @param title
	 * @param header
	 * @param body
	 * @param type
	 * @return
	 */
	public static Alert buildAlertDialog(String title, String header, String body, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(body);
		return alert;
	}

}
