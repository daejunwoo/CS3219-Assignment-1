package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author wgoh
 *
 */

public class CircularShifter {
	public static String BLANK_SPACE = " ";
    private String _line;
    private IgnoreWordHandler _wordsToIgnore;

    public CircularShifter(String line) {
        assert(line != null);
        this._line = line.toLowerCase();
        this._wordsToIgnore = IgnoreWordHandler.getWordsToIgnore();
    }

    public String[] getShifted() {
        String[] listOfWords = this._line.split(BLANK_SPACE);
        String[] shifts = new String[listOfWords.length];
        shifts[0] = this._line;
        
        for (int i=1; i<listOfWords.length; i++) {
            shifts[i] = this.getShiftedLine(i, listOfWords);
        }

        String[] fixedShifts = getShiftsNotIgnored(shifts);
        for (int j=0; j<fixedShifts.length; j++) {
            fixedShifts[j] = capitalizeWordsNotIgnored(fixedShifts[j]);
        }

        return fixedShifts;
    }

    private String getShiftedLine(int idx, String[] listOfWords) {
        StringBuilder builder = new StringBuilder();
        
        for (int i=idx; i<listOfWords.length; i++) {
            builder.append(listOfWords[i]).append(BLANK_SPACE);
        }
        
        for (int j=0; j<idx; j++) {
            builder.append(listOfWords[j]).append(BLANK_SPACE);
        }
        
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    private String[] getShiftsNotIgnored(String[] shifts) {
        ArrayList<String> shiftedList = new ArrayList<String>(Arrays.asList(shifts));

        Iterator<String> iter = shiftedList.iterator();
        while (iter.hasNext()) {
            if (isShiftStartWithIgnored(iter.next())) {
                iter.remove();
            }
        }

        return shiftedList.toArray(new String[shiftedList.size()]);
    }

    private boolean isShiftStartWithIgnored(String line) {
        return this._wordsToIgnore.isWordIgnored(line.split(BLANK_SPACE)[0]);
    }

    private String capitalizeWordsNotIgnored(String shift) {
        String[] listOfWords = shift.split(BLANK_SPACE);
        StringBuilder builder = new StringBuilder();

        for (String str : listOfWords) {
            if (this._wordsToIgnore.isWordIgnored(str)) {
                builder.append(str);
            } else if (str.trim().isEmpty()) {
                continue;
            } else {
                builder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1));
            }
            
            builder.append(BLANK_SPACE);
        }
        
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
