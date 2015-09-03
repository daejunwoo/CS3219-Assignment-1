package kwic;

/**
 * 
 * @author Alan
 *
 */
public class IgnoreWordHandler {
	private static IgnoreWordHandler _instance;
	private Storage _storage;

	private IgnoreWordHandler() {
		this._storage = Storage.getStorage();
	}

	public static IgnoreWordHandler getWordsToIgnore() {
		if (_instance == null) {
			_instance = new IgnoreWordHandler();
		}

		return _instance;
	}

	public void addWordToIgnore(String word) {
		assert(word != null);
		this._storage.addIgnoredWord(word);
	}

	public boolean isWordIgnored(String word) {
		assert(word != null);
		return this._storage.getIgnoredWord().contains(word);
	}
}