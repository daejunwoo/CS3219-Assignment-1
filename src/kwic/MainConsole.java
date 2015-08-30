package kwic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String WELCOME_MESSAGE = "Enter input: ";

	private static final String EMPTY_LINE = "\n";
	private static final String EMPTY_STRING = "";

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
	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

}