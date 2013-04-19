package pl.juglodz.szkolenie.operation;

import com.google.common.base.Strings;

public class OperationFactory {

	private static final String OPERATION_CONCAT = "concat";
	private static final String OPERATION_SUBSTRING = "substring";
	private static final int OPERATION_NAME_ID = 1;
	private static final int MIN_ARG_SIZE = 3;

	public static Operation create(final String[] args) {
		if (args == null) {
			throw new NullPointerException("empty list of arguments");
		}
		// Don't use magic numbers
		if (args.length < MIN_ARG_SIZE) {
			throw new IllegalStateException("min arg size need be gt "
					+ MIN_ARG_SIZE + " currentlly " + args.length);
		}
		// Give me operation
		String operationName = args[OPERATION_NAME_ID];
		Operation o = createOperation(operationName, args);
		return o;
	}

	private static Operation createOperation(String operationName, String[] args) {
		if (Strings.isNullOrEmpty(operationName)) {
			throw new IllegalStateException("Operation name can't be null");
		}
		if (OPERATION_SUBSTRING.equalsIgnoreCase(operationName)) {
			return SubstringOperation.create(args);
		} else if (OPERATION_CONCAT.equalsIgnoreCase(operationName)) {
			return ConcatOperation.create(args);
		} else {
			throw new UnsupportedOperationException("Operation "
					+ operationName + " not supported");
		}
	}

}
