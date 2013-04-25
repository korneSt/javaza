
package pl.juglodz.szkolenie;

import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Scanner;

import pl.juglodz.szkolenie.parser.ParseException;

import com.sun.imageio.plugins.common.InputStreamAdapter;

/**
 * Napisz program laczacy sie ze strona podana jako argument wywolania programu i wypisujacy
 * wszystkie znalezione na niej linki i adresy email wykorzystujac w tym celu wyrazenia regularne
 * (pakiet java.util.regex). Oprocz tego program ma zapisac do pliku wszystkie parametry polaczenia,
 * adres IP komputera na ktorym znajduje sie strona oraz naglowek strony (zawartosc sekcji <head>).
 */
public class App {
    private static final String CMD_EXIT = "exit";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()){
            String param = s.nextLine();
            if (CMD_EXIT.equalsIgnoreCase(param)){
                return; 
            }else {
                try {
                    WebPageParser wpp = new WebPageParserImpl(param);
                    wpp.parse();
                } catch (MalformedURLException e) {
                    System.out.println("Podaj jeszcze raz url poprawny "  +param);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
    }
}
