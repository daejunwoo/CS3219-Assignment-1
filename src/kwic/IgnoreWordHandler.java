package kwic;

import java.util.HashSet;

public class IgnoreWordHandler {
	private static IgnoreWordHandler _instance;
    private HashSet<String> _wordsToIgnore;
    private IgnoreWordHandler() {
        this._wordsToIgnore = new HashSet<String>();
    }

    public static IgnoreWordHandler getWordsToIgnore() {
        if (_instance == null) {
            _instance = new IgnoreWordHandler();
        }

        return _instance;
    }

    public void addWordToIgnore(String word) {
        assert(word != null);
        this._wordsToIgnore.add(word);
    }

    public void removeWordToIgnore(String word) {
        assert(word != null);
        this._wordsToIgnore.remove(word);
    }

    public boolean isWordIgnored(String word) {
        assert(word != null);
        return this._wordsToIgnore.contains(word);
    }
}