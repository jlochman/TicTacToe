package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.entityDomain.GameLogEntity;

public interface GameLogEntityService extends EntityServiceInterface<GameLogEntity> {

	public void info(GameEntity game, String msg);

	public void warn(GameEntity game, String msg);

	public void error(GameEntity game, String msg);

}
