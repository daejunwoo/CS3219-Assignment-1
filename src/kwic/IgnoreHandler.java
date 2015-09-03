package kwic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class IgnoreHandler {

	private static final String IGNOREWORDS_FILE = "ignoreWords.txt";
	private Storage _storage;

	public IgnoreHandler() {
		this._storage = Storage.getStorage();
	}

	public boolean isIgnored(String word) {
		return this._storage.getIgnoredWord().contains(word);
	}

	public void readIgnorewordsFile() {
		File keywordsFile = new File(IGNOREWORDS_FILE);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(keywordsFile)));
			String line;
			while ((line = br.readLine()) != null) {
				this._storage.addIgnoredWord(line);
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