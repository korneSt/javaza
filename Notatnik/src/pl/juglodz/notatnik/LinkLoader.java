package pl.juglodz.notatnik;

import java.util.List;

import android.net.Uri;
import android.os.AsyncTask;

import pl.juglodz.notatnik.data.LinkDTO;

public interface LinkLoader {

	public List<LinkDTO> getAllLinks(Uri webpage, UpdateProgressCallback asyncTask) throws LoadException;
	
}
