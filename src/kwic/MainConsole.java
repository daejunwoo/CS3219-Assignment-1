package kwic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String WELCOME_MESSAGE = "Enter input: ";

	private static final String EMPTY_LINE = "\n";

	private static ArrayList<String> inputList;
	private static Scanner sc;

	public static void main(String[] args) {

		IgnoreHandler ignoreWords = IgnoreHandler.getIgnoreHandler();
		ignoreWords.readIgnorewordsFile();

		inputList = new ArrayList<String>();

		writeMessage(WELCOME_MESSAGE + EMPTY_LINE);

		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			inputList.add(sc.nextLine().toLowerCase());
		}

		CircularShiftHandler circularShift = new CircularShiftHandler(inputList);
		ArrayList<String[]> shiftedList = circularShift.circularShiftLine();

		AlphabetizeHandler alphabetize = new AlphabetizeHandler(shiftedList);
		ArrayList<String> alphabetizedList = alphabetize.alphabetizeLine();

		SortHandler sort = new SortHandler(alphabetizedList);
		ArrayList<String> sortedList = sort.sortLine();

		for (int i = 0; i < sortedList.size(); i++) {
			writeMessage(sortedList.get(i) + EMPTY_LINE);
		}

	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

}