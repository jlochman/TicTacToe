package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.game.GameInstance;

public interface GameEntityService extends EntityServiceInterface<GameEntity>, EntityLogServiceInterface<GameEntity> {

	public GameInstance getGameInstance(GameEntity entity);

	public void setGameInstance(GameEntity entity, GameInstance game);

}
