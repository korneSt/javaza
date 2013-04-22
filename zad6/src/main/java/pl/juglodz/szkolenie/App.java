
package pl.juglodz.szkolenie;

import pl.juglodz.szkolenie.localization.Budynek;
import pl.juglodz.szkolenie.localization.Identyfikator;
import pl.juglodz.szkolenie.localization.Pietro;
import pl.juglodz.szkolenie.localization.Pokoj;

/**
 * Napisz abstrakcyjna klase Lokalizacja a nastepnie dziedziczace z niej klasy Budynek, Pietro,
 * Pokoj. Klasa lokalizacja ma abstrakcyjna metode opis, ktora opisuje dana Lokalizacje i wszystkie
 * jej podLokalizacje. Zaproponuj takie pola i metody klas Budynek, Pietro, Pokoj by zapewnialy one
 * mozliwosc utworzenia trojstopniowej struktury hierarchicznej (Budynek -> Pietra (przypisane do
 * budynku) -> Pokoje (przypisane do pietra)). Kazdy obiekt klasy Lokalizacja powinien posiadac pole
 * klasy Identyfikator. Klasa Identyfikator posiada 3 pola (numer budynku, numer pietra, numer
 * pokoju) i implementuje interfejs Comparable. Zapewnij by w trakcie tworzenia hierarchicznej
 * struktury zapewnione bylo automatyczne tworzenie identyfikatorow. W oparciu o klase Identyfikator
 * napisz metody sprawdzajace relacje pomiedzy dwoma dowolnymi lokalizacjami.
 */
public class App {
    public static void main(String[] args) {
        Budynek a = new Budynek(1);
        Pietro pietro1 = new Pietro(1);
        Pokoj pokoj1 = new Pokoj(1);
        Pokoj pokoj2 = new Pokoj(2);
        Pokoj pokoj3 = new Pokoj(3);
        pietro1.addPokoj(pokoj1);
        pietro1.addPokoj(pokoj2);
        pietro1.addPokoj(pokoj3);
        Pietro pietro2 = new Pietro(2);
        Pietro pietro3 = new Pietro(3);
        Pietro pietro4 = new Pietro(4);
        a.addPietro(pietro1);
        a.addPietro(pietro2);
        a.addPietro(pietro3);
        a.addPietro(pietro4);
        Budynek b = new Budynek(2);
        System.out.println(a.opis());
        
    }
}
