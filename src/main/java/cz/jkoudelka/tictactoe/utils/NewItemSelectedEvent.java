package cz.jkoudelka.tictactoe.utils;

public interface NewItemSelectedEvent<T> {

	public void processNewItem(T newItem);

}
