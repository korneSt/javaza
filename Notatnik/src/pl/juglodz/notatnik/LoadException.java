package pl.juglodz.notatnik;

public class LoadException extends Exception {

	public LoadException() {
		super();
	}

	public LoadException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public LoadException(String detailMessage) {
		super(detailMessage);
	}

	public LoadException(Throwable throwable) {
		super(throwable);
	}

}
