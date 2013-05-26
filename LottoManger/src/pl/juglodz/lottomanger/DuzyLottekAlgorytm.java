package pl.juglodz.lottomanger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DuzyLottekAlgorytm implements LottoAlgorytm {

	private static final int MAX_NUMBER = 49;
	private static final int ILOSC_LICZB = 6;
	private List<Integer> base = new ArrayList<Integer>();
	private Random random = new Random();
	
	
	public DuzyLottekAlgorytm() {
		for (int i = 1; i <= getMaxNumber(); i++) {
			base.add(i);
		}
	}
	
	public DuzyLottekAlgorytm(int maxLiczba) {
		for (int i = 1; i <= maxLiczba; i++) {
			base.add(i);
		}
	}

	public int getMaxNumber(){
		return DuzyLottekAlgorytm.MAX_NUMBER;
	}
	
	public int getIloscLiczb(){
		return DuzyLottekAlgorytm.ILOSC_LICZB;
	}
	
	@Override
	public List<Integer> losuj() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < getIloscLiczb(); i++) {
			int index=  random.nextInt(base.size());
			int liczba =  base.remove(index);
			result.add(liczba);
		}
		return result;
	}

}
