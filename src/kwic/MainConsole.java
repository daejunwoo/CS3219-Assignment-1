package kwic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String WELCOME_MESSAGE = "Enter input: ";

	private static final String EMPTY_LINE = "\n";

	private static ArrayList<String> inputList;
	private static Scanner sc;
	private static Storage _storage;

	public static void main(String[] args) {
		sharedRepo();
	}

	public static void sharedRepo() {
		_storage = Storage.getStorage();
		IgnoreHandler ignoreWords = new IgnoreHandler();
		ignoreWords.readIgnorewordsFile();

		writeMessage(WELCOME_MESSAGE + EMPTY_LINE);

		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			Storage.getStorage().addInputLine(sc.nextLine().toLowerCase());
		}

		CircularShiftHandler circularShift = new CircularShiftHandler();
		circularShift.circularShiftLine();

		AlphabetizeHandler alphabetize = new AlphabetizeHandler();
		alphabetize.alphabetizeLine();

		SortHandler sort = new SortHandler();
		sort.sortLine();

		for (int i = 0; i < _storage.getSortedList().size(); i++) {
			writeMessage(_storage.getSortedList().get(i) + EMPTY_LINE);
		}
	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

}