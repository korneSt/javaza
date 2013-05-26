package pl.juglodz.notatnik.data;

import android.net.Uri;

public class LinkDTO {

	private String alt; 
	private Uri link;
	@Override
	public String toString() {
		return alt;
	}
	
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public void setLink(Uri link) {
		this.link = link;
	}
	
	
}
