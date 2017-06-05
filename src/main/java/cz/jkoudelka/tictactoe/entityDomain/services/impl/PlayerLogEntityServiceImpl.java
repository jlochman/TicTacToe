package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerLogEntityService;

public class PlayerLogEntityServiceImpl implements PlayerLogEntityService {

	@Override
	public GenericEntityDAO<PlayerLogEntity> getDAO() {
		return ServiceLocator.getInstance().getDaos().getPlayerLogDAO();
	}

}
