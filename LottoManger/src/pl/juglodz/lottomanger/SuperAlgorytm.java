package pl.juglodz.lottomanger;

public class SuperAlgorytm extends DuzyLottekAlgorytm {

	private int ileLiczb;
	private int maxLiczba;

	public SuperAlgorytm(int ileLiczb, int maxLiczba) {
		super( maxLiczba);
		this.ileLiczb = ileLiczb;
		this.maxLiczba = maxLiczba;
		if (ileLiczb>maxLiczba){
			throw new IllegalStateException("Podaj większą maxymalna liczbe");
		}
	}
	
	@Override
	public int getIloscLiczb() {
		return ileLiczb;
	}
	
	@Override
	public int getMaxNumber() {
		return maxLiczba;
	}
}
