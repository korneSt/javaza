
package pl.juglodz.szkolenie.localization;

public class Identyfikator implements Comparable<Identyfikator>{

    private int nrBudynku;
    private int nrPietra;
    private int nrPokoju;

    public Identyfikator(Identyfikator i) {
        this.nrBudynku = i.nrBudynku;
        this.nrPietra = i.nrPietra;
        this.nrPokoju = i.nrPokoju;
    }
    
    
    public Identyfikator(int nrBudynku, int nrPietra, int nrPokoju) {
        this.nrBudynku = nrBudynku;
        this.nrPietra = nrPietra;
        this.nrPokoju = nrPokoju;
    }

    public Identyfikator(int nrBudynku, int nrPietra) {
        this.nrBudynku = nrBudynku;
        this.nrPietra = nrPietra;
    }

    public Identyfikator(int nrBudynku) {
        this.nrBudynku = nrBudynku;
    }


    public int getNrBudynku() {
        return nrBudynku;
    }


    public void setNrBudynku(int nrBudynku) {
        this.nrBudynku = nrBudynku;
    }


    public int getNrPietra() {
        return nrPietra;
    }


    public void setNrPietra(int nrPietra) {
        this.nrPietra = nrPietra;
    }


    public int getNrPokoju() {
        return nrPokoju;
    }


    public void setNrPokoju(int nrPokoju) {
        this.nrPokoju = nrPokoju;
    }


    @Override
    public String toString() {
        return "Identyfikator [nrBudynku=" + nrBudynku + ", nrPietra=" + nrPietra + ", nrPokoju=" + nrPokoju + "]";
    }


    @Override
    public int compareTo(Identyfikator o) {
        if (this.nrBudynku>o.nrBudynku){
            return 1;
        }
        if (this.nrBudynku<o.nrBudynku){
            return -1;
        }
        if (this.nrPietra>o.nrPietra){
            return 1;
        }
        if (this.nrPietra<o.nrPietra){
            return -1;
        }
        if (this.nrPokoju>this.nrPokoju){
            return 1;
        }
        if (this.nrPokoju<this.nrPokoju){
            return -1;
        }
        return 0;
    }
    
    

    /*
     * private Identyfikator(Builder builder) { nrBudynku = builder.nbrBudynku; nrPietra =
     * builder.nrPietra; nrPokoju = builder.nrPokoju; } public static Builder CREATOR = new
     * Builder(); public static class Builder { private static final int NOT_SET =
     * Integer.MIN_VALUE; private int nbrBudynku = NOT_SET; private int nrPietra = NOT_SET; private
     * int nrPokoju = NOT_SET; private Builder() { } public Builder zPietrem(int pietro) { nrPietra
     * = pietro; return this; } public Builder zPokojem(int pokoj) { nrPokoju = pokoj; return this;
     * } public Builder budynek(int number) { nbrBudynku = number; return this; } public
     * Identyfikator build() { if (nbrBudynku==NOT_SET){ throw new IllegalStateException(); } return
     * new Identyfikator(this); } }
     */
}
