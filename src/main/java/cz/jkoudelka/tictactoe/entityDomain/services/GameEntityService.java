package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.GameEntity;
import cz.jkoudelka.tictactoe.gameInstance.GameInstance;

/**
 * Service nad {@link GameEntity}
 * 
 * @author jlochman
 *
 */
public interface GameEntityService extends EntityServiceInterface<GameEntity>, EntityLogServiceInterface<GameEntity> {

	/**
	 * prevod historie hry do GameInstance
	 * 
	 * @param entity
	 * @return
	 */
	public GameInstance getGameInstance(GameEntity entity);

	/**
	 * prekopirovani historie hry do GameEntity
	 * 
	 * @param entity
	 * @param game
	 */
	public void setGameInstance(GameEntity entity, GameInstance game);

}
