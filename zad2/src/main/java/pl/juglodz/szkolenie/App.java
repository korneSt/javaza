package pl.juglodz.szkolenie;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import pl.juglodz.szkolenie.operation.Operation;
import pl.juglodz.szkolenie.operation.OperationFactory;
import sun.management.ConnectorAddressLink;

/**
 * Napisz program, ktory pobiera dwie liczby oraz lancuch znakow z wiersza
 * polecen oraz wyswietla fragment podanego lancucha okreslony wprowadzonymi
 * liczbami. Na przyklad:
 * 
 * java Substring Witaj 2 4
 * 
 * powinien wyświetlic:
 * 
 * taj Obsłuż wszystkie mozliwe wyjatki, ktore moga wystapic w przypadku złego
 * zestawu argumentow.
 * 
 */
public class App {
	public static void main(String[] args) {
//		Operation operation = OperationFactory.create(args);
//		String result = operation.execute();
//		System.out.println("Result:: " + result);
//		FileInputStream is=null;
	    
		args= new String[]{"1"};
		App app = new App();
		app.print(args);
	}

    private void print(String[] args) {
        try{
            Integer.parseInt(args[0]);
            System.out.println("parsed");
        }catch (Exception e) {
            System.out.println("eeee");
        }finally{
            System.out.println("finaly");
        }        
    }
}
