package cz.jkoudelka.tictactoe.utils;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * Metody usnadnujici praci s {@link ListView}
 * 
 * @author jlochman
 *
 */
public class ListViewUtils {

	/**
	 * Pro dany listView vybere specificky item.
	 * 
	 * @param listView
	 * @param item
	 */
	public static <T> void select(ListView<T> listView, T item) {
		if (item == null) {
			return;
		}
		listView.getSelectionModel().select(item);
		listView.getFocusModel().focus(listView.getSelectionModel().getSelectedIndex());
		listView.scrollTo(item);
	}

	/**
	 * Pro dany listView vybere item majici stejny ID, jako item predany jako
	 * parametr
	 * 
	 * @param listView
	 * @param item
	 */
	public static <T extends PersistenceObject> void selectByID(ListView<T> listView, T item) {
		if (item == null) {
			return;
		}
		for (T t : listView.getItems()) {
			if (t.getId().equals(item.getId())) {
				select(listView, t);
				return;
			}
		}
	}

	/**
	 * {@link ListView} Zobrazuje string ale obsahuje kolekci objektu.
	 * Nastavenim TextFactory se definuje, jakym zpusobem se objekt prevadi na
	 * string. Interface {@link ToStringConverter} je definovan v teto utilitni
	 * tride.
	 * 
	 * @param listView
	 * @param converter
	 */
	public static <T> void setTextFactory(ListView<T> listView, ToStringConverter<T> converter) {
		listView.setCellFactory(lw -> new ListCell<T>() {
			@Override
			protected void updateItem(T item, boolean empty) {
				super.updateItem(item, empty);
				if (empty) {
					setText(null);
				} else {
					setText(converter.toString(item));
				}
			}
		});
	}

	/**
	 * listView se nastavi, co se ma stat, pokud je vybran novy item. Interface
	 * {@link NewItemSelectedEvent} je definvat v teto utilitni tride
	 * 
	 * @param listView
	 * @param event
	 */
	public static <T> void setNewItemSelectedListener(ListView<T> listView, NewItemSelectedEvent<T> event) {
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<T>() {
			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				event.processNewItem(newValue);
			}
		});
	}

	/**
	 * Specificky prevod objektu na String
	 * 
	 * @author jlochman
	 *
	 * @param <T>
	 */
	public interface ToStringConverter<T> {
		public String toString(T t);
	}

	/**
	 * Definuje metodu, ktera se vola pri zvoleni noveho obejktu.
	 * 
	 * @author jlochman
	 *
	 * @param <T>
	 */
	public interface NewItemSelectedEvent<T> {
		public void processNewItem(T newItem);
	}

}
