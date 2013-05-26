package pl.juglodz.notatnik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import android.content.Context;
import android.os.Environment;
import pl.juglodz.notatnik.data.Notatka;

public class SDCardZapisywaczNotatek implements ZapisywaczNotatek {

	private File extStore;
	private static final String NOTATKA_FILE_NAME = "notatka.txt";
	private File file;

	public SDCardZapisywaczNotatek(Context context) {
		 extStore = Environment.getExternalStorageDirectory();
		 file = new File(extStore.getAbsolutePath() + File.pathSeparator + NOTATKA_FILE_NAME);
	}
	
	@Override
	public void zapisz(Notatka notatka) throws ZapisException {
		if (!extStore.isDirectory() || !extStore.canWrite()){
			throw new ZapisException("Sdcard is not avaliable");
		}
		try {
			FileWriter pw = new FileWriter(file);
			pw.append( notatka.getOstatniaZmiana() +"|" + notatka.getTitle() + "|" + notatka.getTresc());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			throw  new ZapisException("Problem z zapisem pliku", e);
		}
		
	}

}
