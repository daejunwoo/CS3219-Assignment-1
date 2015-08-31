package kwic;

import java.util.ArrayList;
import java.util.Collections;

public class SortHandler {

	private Storage _storage;

	public SortHandler(Storage storage) {
		_storage = storage;
	}

	public void sortLine() {
		ArrayList<String> tempList = _storage.getAlphabetizedList();
		Collections.sort(tempList);
		_storage.setSortedList(tempList);
	}
}