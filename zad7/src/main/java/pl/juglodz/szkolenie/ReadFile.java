package pl.juglodz.szkolenie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ReadFile implements Runnable {

	private File file;
	
	private InputStream    fis;
	private BufferedReader br;
	private String         line;
	
	public ReadFile(File file) throws FileNotFoundException {
		this.file = file;
		fis = new FileInputStream(file);
		br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
	}
	
	@Override
	public void run() {
	    System.out.println(Thread.currentThread().getName() + "started ");
		int lineNr = 0;
		try {
			while ((line = br.readLine()) != null) {
				lineNr++;
			}
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("W pliku " + this.file.getAbsolutePath() + " jest linie " + lineNr + "");
	}

}
