package pl.juglodz.notatnik;

import org.apache.http.HttpException;

public interface HttpManager {

	public String load(String url, UpdateProgressCallback progress) throws HttpException;
	
}


