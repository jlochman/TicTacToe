package cz.jkoudelka.tictactoe.entityDomain.enums;

import cz.jkoudelka.tictactoe.cpu.CPULogicInstance;
import cz.jkoudelka.tictactoe.cpu.impl.CPURandomizer;

public enum CPULogic {

	RANDOMIZER(CPURandomizer.class);

	private Class<? extends CPULogicInstance> logicClazz;

	private CPULogic(Class<? extends CPULogicInstance> logicClazz) {
		this.logicClazz = logicClazz;
	}

	public Class<? extends CPULogicInstance> getLogicClazz() {
		return logicClazz;
	}

}
