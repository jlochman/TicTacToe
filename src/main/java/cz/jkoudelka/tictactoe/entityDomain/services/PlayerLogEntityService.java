package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.PlayerEntity;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;

public interface PlayerLogEntityService extends EntityServiceInterface<PlayerLogEntity> {

	public void info(PlayerEntity player, String msg);

	public void warn(PlayerEntity player, String msg);

	public void error(PlayerEntity player, String msg);

}
