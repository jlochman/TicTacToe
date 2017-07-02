package cz.jkoudelka.tictactoe.graphics.game;

import java.net.URL;
import java.util.ResourceBundle;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.BoardSymbol;
import cz.jkoudelka.tictactoe.entityDomain.enums.CPULogic;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameInitiator;
import cz.jkoudelka.tictactoe.entityDomain.services.GameEntityService;
import cz.jkoudelka.tictactoe.observer.ObserverManager;
import cz.jkoudelka.tictactoe.observer.events.GameCreatedEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class GameFormController implements Initializable {

	@FXML
	private ComboBox<GameInitiator> cbInitiator;
	@FXML
	private ComboBox<BoardSymbol> cbPlayerSymbol;
	@FXML
	private ComboBox<BoardSymbol> cbCPUSymbol;
	@FXML
	private ComboBox<CPULogic> cbCPULogic;

	@FXML
	private Button btnCreate;

	private GameEntity game;

	private GameEntityService gameEntityService = ServiceLocator.getInstance().getGameEntityService();
	private ObserverManager observerManager = ServiceLocator.getInstance().getObserverManager();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnCreate.setOnAction(this::createGamePressed);
		cbInitiator.getItems().addAll(GameInitiator.values());
		cbPlayerSymbol.getItems().addAll(BoardSymbol.values());
		cbCPUSymbol.getItems().addAll(BoardSymbol.values());
		cbCPULogic.getItems().addAll(CPULogic.values());
	}

	public void init(GameEntity game) {
		this.game = game;

		cbInitiator.setValue(game.getInitiator());
		cbPlayerSymbol.setValue(game.getPlayerSymbol());
		cbCPUSymbol.setValue(game.getCpuSymbol());
		cbCPULogic.setValue(game.getCpuLogic());
	}

	private void closeWindow() {
		Stage stage = (Stage) btnCreate.getScene().getWindow();
		stage.close();
	}

	private void createGamePressed(ActionEvent event) {
		game.setInitiator(cbInitiator.getValue());
		game.setPlayerSymbol(cbPlayerSymbol.getValue());
		game.setCpuSymbol(cbCPUSymbol.getValue());
		game.setCpuLogic(cbCPULogic.getValue());
		gameEntityService.persist(game);
		observerManager.raiseEvent(new GameCreatedEvent(game));
		closeWindow();
	}

}
