package cz.jkoudelka.tictactoe.app;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;
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

		PlayerEntity player = new PlayerEntity();
		player.setName("Jan Lochman");
		player.setPwd("pwd");

		PlayerLogEntity playerLog = new PlayerLogEntity();
		playerLog.setLogLevel(LogLevel.WARN);
		playerLog.setMsg("newPlayer");
		player.addLogs(playerLog);

		GameEntity game = new GameEntity();
		game.setHistory("gameHistory, JSON");
		player.addGames(game);

		GameLogEntity gameLog = new GameLogEntity();
		gameLog.setLogLevel(LogLevel.INFO);
		gameLog.setMsg("testMSG");
		game.addLogs(gameLog);

		ServiceLocator.getInstance().getPlayerService().persist(player);

		App.launch(args);
	}

}
