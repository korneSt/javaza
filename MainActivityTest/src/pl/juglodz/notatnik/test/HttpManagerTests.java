package pl.juglodz.notatnik.test;

import junit.framework.Assert;

import org.apache.http.HttpException;

import pl.juglodz.notatnik.HttpManager;
import pl.juglodz.notatnik.MyHttpManger;
import pl.juglodz.notatnik.UpdateProgressCallback;
import android.test.AndroidTestCase;

public class HttpManagerTests extends AndroidTestCase {

	
	public void testShouldReadGoogle() throws HttpException{
		//GIVEN I have http manager and google.pl url and I need load this webside
		HttpManager httpManeger = new MyHttpManger();
		String url = "http://www.goz.pl";
		String expectedStart = "<?xml";
		//WHEN I loading
		UpdateProgressCallback progress = new UpdateProgressCallback() {
			
			@Override
			public void onProgress(int ile) {
				
			}
		};
		String strona = httpManeger.load(url, progress);
		//THEN expect loaded webside
		Assert.assertTrue(strona.startsWith(expectedStart));
	}
	
}
