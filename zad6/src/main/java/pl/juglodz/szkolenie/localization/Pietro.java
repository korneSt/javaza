package pl.juglodz.szkolenie.localization;

import java.util.ArrayList;
import java.util.List;

public class Pietro extends Lokalizacja {

    private final List<Pokoj> pokoje;
    private final int numer;
    
    
    public Pietro(int numer) {
        this.numer = numer;
        pokoje = new ArrayList<Pokoj>();
        identyfikator  = new Identyfikator(0, this.numer);
    }
    
    public void addPokoj(Pokoj p){
        p.setPietro(identyfikator);
        pokoje.add(p);
    }
    
    @Override
    public String opis() {
        StringBuilder sb = new StringBuilder();
        sb.append("> > Pietro numer " + numer +" z pokojami: "+identyfikator+"\n");
        for (Pokoj pokoj : pokoje) {
            sb.append(pokoj.opis());
        }
        return sb.toString();
    }

    public void setBudynek(Identyfikator budynek) {
        identyfikator = new Identyfikator(budynek);
        identyfikator.setNrPietra(numer);
    }

}
