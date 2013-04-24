package pl.juglodz.szkolenie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Napisz program, ktory pobiera liste plikow z linii polecen i wyswietla liczbe
 * wierszy kazdego z nich. Program powinien utworzyc jeden watek dla kazdego z
 * plikow i uzyc tych watkow do zliczenia liczby wierszy kazdego z plikow
 * rownoczenie. Utworz wersje programu, ktora odczytuje pliki nie jednoczesnie a
 * sekwencyjnie. Porownaj wydajnosc wielowatkowego i jednowatkowego programu
 * uzywajac System.currentTimeMillis() do okreslenia czasu wykonania. Porownania
 * dokonaj dla dwoch, trzech i pieciu plikow.
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		BufferedReader klawiatura = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Podaj sciedke do katalogu: ");
		try {
			String path = klawiatura.readLine();
			File katalog = new File(path);
			if(!katalog.isDirectory()) {
				System.out.println("To nie jest katalog");
				return;
			}
			File[] files = katalog.listFiles();
			ArrayList<Thread> threads = new ArrayList<Thread>();
			ArrayList<Thread> threads2 = new ArrayList<Thread>();
			for (File file : files) {
				if(!file.isDirectory()){
					Thread t1 = new Thread(new ReadFile(file));
					threads.add(t1);
					
					Thread t2 = new Thread(new ReadFile(file));
					threads2.add(t2);
				}
			}

			//synchronicznie
			long startTime = System.currentTimeMillis();
			for (Thread thread : threads) {
				thread.start();
				thread.join();
			}
			System.out.println("Trwalo to: " + (System.currentTimeMillis() - startTime) + "ms");
			
			//asynchronicznie - czyli wszytskie na raz bez czekania az poprzedni sie skonczy
			startTime = System.currentTimeMillis();
			for (Thread thread : threads2) {
				thread.start(); //startujemy watek jeden po drugim odrazu
			}
			for (Thread thread : threads2) {
				thread.join(); //czekamy na zakonczenie watku
			}
			System.out.println("Trwalo to: " + (System.currentTimeMillis() - startTime) + "ms");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
