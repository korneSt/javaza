package pl.juglodz.notatnik;

import pl.juglodz.notatnik.data.Notatka;

public interface ZapisywaczNotatek {
	
	public void zapisz(Notatka notatka) throws ZapisException;
	
}
