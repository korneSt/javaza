package pl.juglodz.szkolenie.operation;

public class SubstringOperation implements Operation{

	private static final int ARG_STRING_ID = 1;
	private static final int ARG_START_ID = 2;
	private static final int ARG_END_ID = 3;
	private final String string;
	private final int start;
	private final int end;

	private SubstringOperation(String string, int start, int end) {
		this.string = string;
		this.start = start;
		this.end = end;
		
	}

	public static SubstringOperation create(String[] args){
		String string = args[ARG_STRING_ID];
		String sStart = args[ARG_START_ID];
		String sEnd = args[ARG_END_ID];
		return new SubstringOperation(string, Integer.valueOf(sStart), Integer.valueOf(sEnd));
	}
	
	@Override
	public String execute() {
		return string.substring(start, end);
	}

	

}
