package kwic;

public class CircularShiftHandler {
	
	private String _line;
	private IgnoreHandler _ignoreHandler;
	
	public CircularShiftHandler(String line) {
		this._line = line;
		this._ignoreHandler = IgnoreHandler.getIgnoreHandler();
	}
}