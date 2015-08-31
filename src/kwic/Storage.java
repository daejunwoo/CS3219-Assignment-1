package kwic;

import java.util.ArrayList;
import java.util.HashSet;

public class Storage {

	private static ArrayList<String> _inputList;
	private static ArrayList<String[]> _shiftedList;
	private static HashSet<String> _ignoredWords;
	private static ArrayList<String> _alphabetizedList;
	private static ArrayList<String> _sortedList;
	private static Storage _instance;

	public Storage() {
		_inputList = new ArrayList<String>();
		_ignoredWords = new HashSet<>();
		_shiftedList = new ArrayList<String[]>();
		_alphabetizedList = new ArrayList<String>();
	}

	public static Storage getStorage() {
		if (_instance == null) {
			_instance = new Storage();
		}
		return _instance;
	}

	public void addInputLine(String line) {
		_inputList.add(line);
	}

	public ArrayList<String> getInputList() {
		return _inputList;
	}

	public void addIgnoredWord(String ignoredWord) {
		_ignoredWords.add(ignoredWord);
	}

	public HashSet<String> getIgnoredWord() {
		return _ignoredWords;
	}

	public void addShiftedLine(String[] line) {
		_shiftedList.add(line);
	}

	public ArrayList<String[]> getShiftedList() {
		return _shiftedList;
	}

	public void addAlphabetizedLine(String line) {
		_alphabetizedList.add(line);
	}

	public ArrayList<String> getAlphabetizedList() {
		return _alphabetizedList;
	}

	public void setSortedList(ArrayList<String> sortedList) {
		_sortedList = sortedList;
	}

	public ArrayList<String> getSortedList() {
		return _sortedList;
	}
}