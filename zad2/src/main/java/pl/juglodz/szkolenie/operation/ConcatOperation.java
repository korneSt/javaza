package pl.juglodz.szkolenie.operation;

public class ConcatOperation implements Operation {

	private final String str1;
	private final String str2;

	private ConcatOperation(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public String execute() {
		return str1.concat(str2);
	}

	public static Operation create(String[] args) {
		String str1 = args[2];
		String str2 = args[3];
		return new ConcatOperation(str1, str2);
	}

}
