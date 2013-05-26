package pl.juglodz.lottomanger;

public class ExpressLotekAlgorytm extends DuzyLottekAlgorytm {

	private static final int MAX_NUMBER = 42;
	private static final int ILOSC_LICZB = 5;
	
	public ExpressLotekAlgorytm() {
		super();
	}

	@Override
	public int getMaxNumber() {
		return MAX_NUMBER;
	}

	@Override
	public int getIloscLiczb() {
		return ILOSC_LICZB;
	}
	
}
