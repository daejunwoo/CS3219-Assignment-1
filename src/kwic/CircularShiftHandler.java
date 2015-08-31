package kwic;

import java.util.ArrayList;

public class CircularShiftHandler {

	private Storage _storage;
	private static final String BLANK_SPACE = " ";

	public CircularShiftHandler(Storage storage) {
		_storage = storage;
	}

	public void circularShiftLine() {

		for (int a = 0; a < _storage.getInputList().size(); a++) {
			String[] lineArray = _storage.getInputList().get(a).split(BLANK_SPACE);
			ArrayList<String> que = new ArrayList<String>();

			for (int i = 0; i < lineArray.length; i++) {

				String result[] = new String[lineArray.length];

				if (!_storage.getIgnoredWord().contains(lineArray[i])) { // is
																			// keyword
					for (int j = i; j < lineArray.length; j++) {
						result[j - i] = lineArray[j];
					}

					for (int k = 0; k < que.size(); k++) {
						result[lineArray.length - i + k] = que.get(k);
					}

					que.add(lineArray[i]);
					_storage.addShiftedLine(result);

				} else {
					que.add(lineArray[i]);
				}
			}
		}
	}
}