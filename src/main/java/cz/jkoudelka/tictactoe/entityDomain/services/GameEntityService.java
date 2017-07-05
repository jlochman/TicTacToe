package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.game.Game;

public interface GameEntityService extends EntityServiceInterface<GameEntity> {

	public Game getGame(GameEntity entity);

	public void setGame(GameEntity entity, Game game);

}
