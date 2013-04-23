package pl.juglodz.szkolenie.localization;

public abstract class Lokalizacja {

    protected Identyfikator identyfikator;
    public abstract String opis();
   public Identyfikator getID(){
       return identyfikator;
   }   
}
