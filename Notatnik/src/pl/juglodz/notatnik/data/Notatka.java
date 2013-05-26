package pl.juglodz.notatnik.data;

public class Notatka {
	
	private String title;
	private String tresc;
	private long ostatniaZmiana;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTresc() {
		return tresc;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}
	public long getOstatniaZmiana() {
		return ostatniaZmiana;
	}
	public void setOstatniaZmiana(long ostatniaZmiana) {
		this.ostatniaZmiana = ostatniaZmiana;
	}
	
	
}
