package kwic;

import java.util.ArrayList;

public class CircularShiftHandler {

	private ArrayList<String> _inputList;
	private IgnoreHandler _ignoreList;
	private ArrayList<String[]> _shiftedList;
	private static final String BLANK_SPACE = " ";

	public CircularShiftHandler(ArrayList<String> inputList) {
		this._inputList = inputList;
		this._ignoreList = IgnoreHandler.getIgnoreHandler();
		this._shiftedList = new ArrayList<String[]>();
	}

	public ArrayList<String[]> circularShiftLine() {

		for (int a = 0; a < _inputList.size(); a++) {
			String[] lineArray = _inputList.get(a).split(BLANK_SPACE);
			ArrayList<String> que = new ArrayList<String>();

			for (int i = 0; i < lineArray.length; i++) {

				String result[] = new String[lineArray.length];

				if (!_ignoreList.isIgnored(lineArray[i])) { // is keyword
					for (int j = i; j < lineArray.length; j++) {
						result[j - i] = lineArray[j];
					}

					for (int k = 0; k < que.size(); k++) {
						result[lineArray.length - i + k] = que.get(k);
					}

					que.add(lineArray[i]);
					_shiftedList.add(result);

				} else {
					que.add(lineArray[i]);
				}
			}
		}
		return _shiftedList;
	}
}