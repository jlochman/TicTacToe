/**
 * Deklarace DAO jako interface. Intervace
 * {@link cz.jkoudelka.tictactoe.DAO.GenericEntityDAO} poskytuje zakladni metody
 * pro pristup k entitam. DAO nad konkretnimi entitami tento interface extenduji
 * a pripadne si vynucuji implementaci sobe specificikych metod (napr. se muze
 * jednat o ziskani poctu vyteznych her pro danou CPULogicInstance, ktera by
 * patrila do GameEntityDAO).
 * 
 * @author jlochman
 *
 */
package cz.jkoudelka.tictactoe.DAO;