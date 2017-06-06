package cz.jkoudelka.tictactoe.graphics.common;

import javafx.scene.layout.Pane;

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
