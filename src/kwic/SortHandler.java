package kwic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Alan
 *
 */
public class SortHandler {

	private Storage _storage;

	public SortHandler() {
		this._storage = Storage.getStorage();
	}

	public void sortLine() {
		ArrayList<String> tempList = _storage.getAlphabetizedList();
		Collections.sort(tempList);
		_storage.setSortedList(tempList);
	}
}