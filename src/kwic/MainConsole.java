package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String EMPTY_LINE = "\n";
	private static final String DESIGN_PROMPT = "1.Shared Repository" + EMPTY_LINE + "2. TBC " + EMPTY_LINE
			+ "Enter 1 or 2: ";
	private static final String FILENAME_PROMPT = "Enter the file name with extention : ";
	private static final String INVALID_FILE = "File name does not exist";
	private static final String DESGIN1 = "1"; // shared repository
	private static final String DESIGN2 = "2";
	private static Scanner inputScanner;
	private static Scanner fileScanner;

	private static File file;

	public static void main(String[] args) throws FileNotFoundException {

		file = null;
		while (file == null) {
			inputScanner = new Scanner(System.in);
			file = getInputFile();
		}

		writeMessage(DESIGN_PROMPT + EMPTY_LINE);

		String inputDesign = inputScanner.next().trim();

		switch (inputDesign) {
		case DESGIN1:
			ShareRepository sr = new ShareRepository(file);
			ArrayList<String> resultList = sr.sharedRepo();
			for (int i = 0; i < resultList.size(); i++) {
				writeMessage(resultList.get(i) + EMPTY_LINE);
			}
			break;
		case DESIGN2:
			break;
		default:
			break;
		}
	}

	public static File getInputFile() {

		writeMessage(FILENAME_PROMPT);

		try {
			File file = new File(inputScanner.nextLine());
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