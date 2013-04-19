package pl.juglodz.szkolenie;

import pl.juglodz.szkolenie.operation.Operation;
import pl.juglodz.szkolenie.operation.OperationFactory;

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
		Operation operation = OperationFactory.create(args);
		String result = operation.execute();
		System.out.println("Result:: " + result);
	}
}
