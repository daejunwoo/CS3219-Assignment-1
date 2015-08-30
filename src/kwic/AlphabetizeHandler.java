package kwic;

import java.util.ArrayList;

public class AlphabetizeHandler {

	private ArrayList<String[]> _shiftedList;
	private ArrayList<String> _alphabetizedList;
	private IgnoreHandler _ignoreList;
	private static final String EMPTY_STRING = "";
	private static final String BLANK_SPACE = " ";

	public AlphabetizeHandler(ArrayList<String[]> shiftedList) {
		this._shiftedList = shiftedList;
		this._alphabetizedList = new ArrayList<String>();
		this._ignoreList = IgnoreHandler.getIgnoreHandler();
	}

	public ArrayList<String> alphabetizeLine() {

		for (int a = 0; a < _shiftedList.size(); a++) {
			String[] lineArray = _shiftedList.get(a);
			String result = EMPTY_STRING;
			for (int i = 0; i < lineArray.length; i++) {

				if (!_ignoreList.isIgnored(lineArray[i])) {
					result += lineArray[i].substring(0, 1).toUpperCase() + lineArray[i].substring(1) + BLANK_SPACE;
				} else {
					result += lineArray[i].toLowerCase() + BLANK_SPACE;
				}
			}
			_alphabetizedList.add(result.trim());
		}
		return _alphabetizedList;
	}

}