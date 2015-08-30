package kwic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class IgnoreHandler {

	private static final String IGNOREWORDS_FILE = "ignoreWords.txt";
	private HashSet<String> _ignoreList;
	private static IgnoreHandler _instance;

	private IgnoreHandler() {
		this._ignoreList = new HashSet<String>();
	}

	public static IgnoreHandler getIgnoreHandler() {
		if (_instance == null) {
			_instance = new IgnoreHandler();
		}
		return _instance;
	}

	public boolean isIgnored(String word) {
		return this._ignoreList.contains(word);
	}

	public void readIgnorewordsFile() {
		File keywordsFile = new File(IGNOREWORDS_FILE);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(keywordsFile)));
			String line;
			while ((line = br.readLine()) != null) {
				_ignoreList.add(line);
			}
		} catch (FileNotFoundException e1) {

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