package kwic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {

	private static final String IGNOREWORDS_FILE = "ignoreWords.txt";
	private static final String WELCOME_MESSAGE = "Enter input: ";

	private static final String EMPTY_LINE = "\n";
	private static final String EMPTY_STRING = "";
	private static final String BLANK_SPACE = " ";

	private static ArrayList<String> ignoreList = new ArrayList<String>();
	private static ArrayList<String> inputList;
	private static Scanner sc;

	public static void main(String[] args) {

		readIgnorewordsFile();

		writeMessage(WELCOME_MESSAGE + EMPTY_LINE);

		sc = new Scanner(System.in);
		inputList = new ArrayList<String>();

		while (sc.hasNextLine()) {
			inputList.add(sc.nextLine());
		}
	}

	public static void writeMessage(String msg, String... args) {
		msg = String.format(msg, (Object[]) args);
		System.out.print(msg);
	}

	private static void readIgnorewordsFile() {
		File keywordsFile = new File(IGNOREWORDS_FILE);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(keywordsFile)));
			String line;
			while ((line = br.readLine()) != null) {
				ignoreList.add(line);
			}
		} catch (FileNotFoundException e1) {
			writeMessage("Error displaying help message.");
		} catch (IOException e2) {
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}
}