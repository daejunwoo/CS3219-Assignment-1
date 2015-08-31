package kwic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String WELCOME_MESSAGE = "Enter input: ";

	private static final String EMPTY_LINE = "\n";

	private static ArrayList<String> inputList;
	private static Scanner sc;

	public static void main(String[] args) {

		Storage storage = new Storage();
		IgnoreHandler ignoreWords = new IgnoreHandler(storage);
		ignoreWords.readIgnorewordsFile();

		writeMessage(WELCOME_MESSAGE + EMPTY_LINE);

		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			storage.addInputLine(sc.nextLine().toLowerCase());
		}

		CircularShiftHandler circularShift = new CircularShiftHandler(storage);
		circularShift.circularShiftLine();

		AlphabetizeHandler alphabetize = new AlphabetizeHandler(storage);
		alphabetize.alphabetizeLine();

		SortHandler sort = new SortHandler(storage);
		sort.sortLine();

		for (int i = 0; i < storage.getSortedList().size(); i++) {
			writeMessage(storage.getSortedList().get(i) + EMPTY_LINE);
		}

	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

}