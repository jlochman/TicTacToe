package cz.jkoudelka.tictactoe.entityDomain.services;

import cz.jkoudelka.tictactoe.entityDomain.LogEntity;

public interface LogEntityService extends EntityServiceInterface<LogEntity> {

	public void info(String msg);

	public void warn(String msg);

	public void error(String msg);

}
