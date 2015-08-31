package kwic;

public class AlphabetizeHandler {

	private static final String EMPTY_STRING = "";
	private static final String BLANK_SPACE = " ";

	private Storage _storage;

	public AlphabetizeHandler(Storage storage) {
		_storage = storage;
	}

	public void alphabetizeLine() {

		for (int a = 0; a < _storage.getShiftedList().size(); a++) {
			String[] lineArray = _storage.getShiftedList().get(a);
			String result = EMPTY_STRING;
			for (int i = 0; i < lineArray.length; i++) {

				if (!_storage.getIgnoredWord().contains(lineArray[i])) {
					result += lineArray[i].substring(0, 1).toUpperCase() + lineArray[i].substring(1) + BLANK_SPACE;
				} else {
					result += lineArray[i].toLowerCase() + BLANK_SPACE;
				}
			}
			_storage.addAlphabetizedLine(result.trim());
		}
	}

}