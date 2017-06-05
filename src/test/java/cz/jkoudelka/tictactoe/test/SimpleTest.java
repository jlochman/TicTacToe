package cz.jkoudelka.tictactoe.test;

import java.util.Date;

import org.junit.Test;

import cz.jkoudelka.tictactoe.app.ServiceLocator;
import cz.jkoudelka.tictactoe.entityDomain.LogEntity;
import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;

public class SimpleTest {

	@Test
	public void simpleTest() {
		ServiceLocator.getInstance().initializeService();

		LogEntity log = new LogEntity();
		log.setLoggedDate(new Date());
		log.setLogLevel(LogLevel.INFO);
		ServiceLocator.getInstance().getLogService().persist(log);

		log.setMsg("msg");
		ServiceLocator.getInstance().getLogService().update(log);
	}

}
