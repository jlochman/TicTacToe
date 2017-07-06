/**
 * Obsahuje tridy a servicy popisujici hru. GameEntity sice popis hry take
 * obsahuje, ale pro pohodlnejsi manipulaci se hrou je vhodne
 * {@link cz.jkoudelka.tictactoe.entityDomain.GameEntity} prevest do
 * {@link cz.jkoudelka.tictactoe.gameInstance.GameInstance}, se kterou se
 * pohodlne manipuluje. Nasledne se
 * {@link cz.jkoudelka.tictactoe.gameInstance.GameInstance} prevadi zpet do
 * {@link cz.jkoudelka.tictactoe.entityDomain.GameEntity} K tomu se vyuziva
 * JSON.
 * 
 * @author jlochman
 *
 */
package cz.jkoudelka.tictactoe.gameInstance;