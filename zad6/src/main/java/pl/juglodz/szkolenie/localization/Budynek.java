package pl.juglodz.szkolenie.localization;

import java.util.ArrayList;
import java.util.List;

public class Budynek extends Lokalizacja {

    private final int numer;
    private List<Pietro> pietra;
    
    public Budynek(int numer) {
        this.numer = numer;
        identyfikator = new Identyfikator(numer);
        pietra = new ArrayList<Pietro>();
    }
    
    
    public void addPietro(Pietro pietro){
        pietro.setBudynek(identyfikator);
        pietra.add(pietro);
    }
    
    @Override
    public String opis() {
        StringBuilder sb = new StringBuilder();
        sb.append("> Budynek numer " + numer + " z pietrami "+identyfikator+"+\n");
        for (Pietro pietro : pietra) {
            sb.append(pietro.opis());
        }
        return sb.toString();
    }


    public int getNumer() {
        return numer;
    }

}
