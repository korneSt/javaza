package pl.juglodz.notatnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpException;

import pl.juglodz.notatnik.data.LinkDTO;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

public class MyLinkLoader implements LinkLoader {

	private static final String TAG = "MyLinkLoader";
	HttpManager manager;
	String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	Pattern linkPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

	public MyLinkLoader() {
		manager = new MyHttpManger();
	}

	@Override
	public List<LinkDTO> getAllLinks(Uri webpage, UpdateProgressCallback progress)  throws LoadException{
		ArrayList<LinkDTO> links = new ArrayList<LinkDTO>();
		try {
			progress.onProgress(12);
			String strona = manager.load(webpage.toString(), progress);
			Matcher pageMatcher = linkPattern.matcher(strona);
			while(pageMatcher.find()){
				LinkDTO link = new LinkDTO();
				String ll = pageMatcher.group();
				link.setAlt(ll);
			    links.add(link);
			}
			progress.onProgress(90);
		} catch (HttpException e) {
			throw new LoadException("Bład przy szukaniu linkow ", e);
		}
		return links;
	}

	
}
