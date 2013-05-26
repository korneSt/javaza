package pl.juglodz.notatnik;

import java.util.List;

import pl.juglodz.notatnik.data.LinkDTO;
import android.net.Uri;

public interface AsynLinkLoader  {

	public void getAllLinks(Uri webside, LinkCallback callback);

}
