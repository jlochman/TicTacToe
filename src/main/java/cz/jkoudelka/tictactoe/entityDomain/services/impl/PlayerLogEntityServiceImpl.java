package cz.jkoudelka.tictactoe.entityDomain.services.impl;

import cz.jkoudelka.tictactoe.DAO.GenericEntityDAO;
import cz.jkoudelka.tictactoe.app.DAOLocator;
import cz.jkoudelka.tictactoe.entityDomain.PlayerLogEntity;
import cz.jkoudelka.tictactoe.entityDomain.services.PlayerLogEntityService;

/**
 * Implementace servicy nad {@link PlayerLogEntity}
 * 
 * @author jlochman
 *
 */
public class PlayerLogEntityServiceImpl implements PlayerLogEntityService {

	@Override
	public GenericEntityDAO<PlayerLogEntity> getDAO() {
		return DAOLocator.getInstance().getPlayerLogDAO();
	}

}
