package pl.juglodz.szkolenie.localization;

public class Pokoj extends Lokalizacja {

    
    private final int numer;

    public Pokoj(int numer) {
        this.numer = numer;
    }
    
    @Override
    public String opis() {
        return "> > > Pokoj numer " + numer + identyfikator+" \n";
    }

    public void setPietro(Identyfikator pietro) {
        identyfikator = new Identyfikator(pietro);
        identyfikator.setNrPokoju(numer);
    }

}
