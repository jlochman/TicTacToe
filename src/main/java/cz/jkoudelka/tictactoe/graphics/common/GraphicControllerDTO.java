package cz.jkoudelka.tictactoe.graphics.common;

import javafx.scene.layout.Pane;

/**
 * JavaFX pracuje podle vzoru MVC (Model, View, Controller). Modelem je zde
 * zbytek aplikace, ktery vysvicuje svoji funkcionalitu prostrednictvim service.
 * View predstavuji soubory .fxml a Controller jim prislusejici Controllery. Pri
 * nacteni grafiky je treba udrzovat sparovanou grafiku se svym controllerem a o
 * to se stara tato trida.
 * 
 * @author jlochman
 *
 */
public class GraphicControllerDTO {

	private Object controller;
	private Pane graphic;

	public GraphicControllerDTO(Object controller, Pane graphic) {
		super();
		this.controller = controller;
		this.graphic = graphic;
	}

	public Object getController() {
		return controller;
	}

	public void setController(Object controller) {
		this.controller = controller;
	}

	public Pane getGraphic() {
		return graphic;
	}

	public void setGraphic(Pane graphic) {
		this.graphic = graphic;
	}

}
