package pl.juglodz.notatnik;

public class ZapisException extends Exception {

	public ZapisException() {
		super();
	}

	public ZapisException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public ZapisException(String detailMessage) {
		super(detailMessage);
	}

	public ZapisException(Throwable throwable) {
		super(throwable);
	}

}
