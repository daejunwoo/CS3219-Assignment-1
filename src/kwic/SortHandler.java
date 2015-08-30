package kwic;

import java.util.ArrayList;
import java.util.Collections;

public class SortHandler {

	private ArrayList<String> _alphabetizedList;

	public SortHandler(ArrayList<String> alphabetizedList) {
		this._alphabetizedList = alphabetizedList;
	}

	public ArrayList<String> sortLine() {
		Collections.sort(_alphabetizedList);
		return _alphabetizedList;
	}
}