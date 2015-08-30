package kwic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String WELCOME_MESSAGE = "Enter input: ";

	private static final String EMPTY_LINE = "\n";
	private static final String EMPTY_STRING = "";
	private static final String BLANK_SPACE = " ";

	private static ArrayList<String> inputList;
	private static Scanner sc;

	public static void main(String[] args) {

		inputList = new ArrayList<String>();

		writeMessage(WELCOME_MESSAGE + EMPTY_LINE);

		sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			inputList.add(sc.nextLine());
		}
	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

}