package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Alan
 *
 */
public class ShareRepository {

	private static Storage _storage;
	private static Scanner _fileScanner;
	private File _file;

	public ShareRepository(File file) {
		this._file = file;
		_storage = Storage.getStorage();
	}

	public ArrayList<String> sharedRepo() throws FileNotFoundException {
		_fileScanner = new Scanner(_file);
		IgnoreWords ignoreWords = new IgnoreWords();
		ignoreWords.readIgnorewordsFile();
		try {

		} catch (Exception ex) {

		}
		while (_fileScanner.hasNextLine()) {
			Storage.getStorage().addInputLine(_fileScanner.nextLine().toLowerCase());
		}

		CircularShiftHandler circularShift = new CircularShiftHandler();
		circularShift.circularShiftLine();

		AlphabetizeHandler alphabetize = new AlphabetizeHandler();
		alphabetize.alphabetizeLine();

		SortHandler sort = new SortHandler();
		sort.sortLine();

		return _storage.getSortedList();
	}

}