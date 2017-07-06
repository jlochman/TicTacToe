package cz.jkoudelka.tictactoe.utils;

import cz.jkoudelka.tictactoe.entityDomain.PersistenceObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ListViewUtils {

	public static <T> void select(ListView<T> listView, T item) {
		if (item == null) {
			return;
		}
		listView.getSelectionModel().select(item);
		listView.getFocusModel().focus(listView.getSelectionModel().getSelectedIndex());
		listView.scrollTo(item);
	}

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

	public static <T> void setNewItemSelectedListener(ListView<T> listView, NewItemSelectedEvent<T> event) {
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<T>() {
			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				event.processNewItem(newValue);
			}
		});
	}

	public interface ToStringConverter<T> {
		public String toString(T t);
	}

	public interface NewItemSelectedEvent<T> {
		public void processNewItem(T newItem);
	}

}
