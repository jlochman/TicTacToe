package cz.jkoudelka.tictactoe.entityDomain.enums;

import cz.jkoudelka.tictactoe.cpu.CPULogicInstance;
import cz.jkoudelka.tictactoe.cpu.impl.CPURandomizer;

/**
 * Vypis dostupnych logik CPU. V construktoru se predava trida logiky do
 * {@link #logicClazz}, ktera je pro typovou bezpecnost definovana pres generiku
 * (? extends CPULogicInstance). Pokud bude vytvorena nova instance logiky CPU,
 * je treba vytvorit novou hodnotu tohoto enmu a instanci CPU do ni predat.
 * 
 * @author jlochman
 *
 */
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
