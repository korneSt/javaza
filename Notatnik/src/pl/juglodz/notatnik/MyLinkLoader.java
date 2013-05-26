package pl.juglodz.notatnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.apache.http.HttpException;

import pl.juglodz.notatnik.data.LinkDTO;
import android.net.Uri;
import android.util.Log;

public class MyLinkLoader implements LinkLoader {

	private static final String TAG = "MyLinkLoader";
	HttpManager manager; 
	
	public MyLinkLoader() {
		manager = new MyHttpManger();
	}
	
	@Override
	public List<LinkDTO> getAllLinks(Uri webpage) {
		try {
			String strona = manager.load(webpage.toString());
			Log.d(TAG,strona);
		} catch (HttpException e) {
			Log.d(TAG, e.getMessage(), e);
		}
		
		

		return Collections.emptyList();
	}

	
}
