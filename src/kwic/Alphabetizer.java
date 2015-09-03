package kwic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author wgoh
 *
 */

public class Alphabetizer {
	private ArrayList<String> _lines;

    public Alphabetizer() {
        this._lines = new ArrayList<String>();
    }

    public void addLines(String[] lines) {
        for (String str : lines) {
            this._lines.add(str);
        }
    }

    public String[] getSorted() {
        Collections.sort(this._lines);
        return this._lines.toArray(new String[this._lines.size()]);
    }
}
