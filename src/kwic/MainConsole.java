package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String EMPTY_LINE = "\n";
	private static ArrayList<String> inputList;
	private static Scanner sc;

	private static final String DESIGN_PROMPT = "1. Shared Repository" + EMPTY_LINE + "2. Pipe and Filter " + EMPTY_LINE
			+ "Enter 1 or 2: ";
	private static final String FILENAME_PROMPT = "Enter the file name with extension : ";
	private static final String INVALID_FILE = "File name does not exist";
	private static final String DESIGN1 = "1"; // shared repository
	private static final String DESIGN2 = "2"; // pipe and filter
	private static Scanner inputScanner;
	private static Scanner fileScanner;

	private static File file;

	public static void main(String[] args) throws FileNotFoundException {

		file = null;

		writeMessage(DESIGN_PROMPT + EMPTY_LINE);

		inputScanner = new Scanner(System.in);

		String inputDesign = inputScanner.next().trim();

		switch (inputDesign) {
		case DESIGN1:
			while (file == null) {
				file = getInputFile();
			}

			ShareRepository sr = new ShareRepository(file);
			ArrayList<String> resultList = sr.sharedRepo();
			for (int i = 0; i < resultList.size(); i++) {
				writeMessage(resultList.get(i) + EMPTY_LINE);
			}
			break;
		case DESIGN2:
			pipeAndFilter();
			break;
		default:
			break;
		}
	}

	public static void pipeAndFilter() {
		sc = new Scanner(System.in);

		// Enter movie titles or similar stuff
		writeMessage("### Enter movie titles - terminate with empty line ###\n");

		inputList = new ArrayList<String>();
		String userInput = sc.nextLine();
		while (!userInput.isEmpty()) {
			inputList.add(userInput);
			userInput = sc.nextLine();
		}

		// Enter words to ignore
		writeMessage("### Enter words to ignore - terminate with empty line ###\n");

		IgnoreWordHandler wordsToIgnore = IgnoreWordHandler.getWordsToIgnore();
		String ignoreWord = sc.nextLine();
		while (!ignoreWord.isEmpty()) {
			wordsToIgnore.addWordToIgnore(ignoreWord);
			ignoreWord = sc.nextLine();
		}

		Alphabetizer alphabetizer = new Alphabetizer();
		for (String str : inputList) {
			CircularShifter shifter = new CircularShifter(str);
			alphabetizer.addLines(shifter.getShifted());
		}

		String[] results = alphabetizer.getSorted();
		for (String str : results) {
			writeMessage(str + "\n");
		}
	}

	public static File getInputFile() {

		writeMessage(FILENAME_PROMPT);

		try {
			File file = new File(inputScanner.next());
			fileScanner = new Scanner(file);
			return file;
		} catch (Exception ex) {
			writeMessage(INVALID_FILE + EMPTY_LINE);
			return null;
		}
	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

}