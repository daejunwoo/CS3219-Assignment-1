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
		pipeAndFilter();
		// sharedRepo();
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