package pl.juglodz.notatnik;

import java.util.List;

import android.net.Uri;

import pl.juglodz.notatnik.data.LinkDTO;

public interface LinkLoader {

	public List<LinkDTO> getAllLinks(Uri webpage);
	
}
