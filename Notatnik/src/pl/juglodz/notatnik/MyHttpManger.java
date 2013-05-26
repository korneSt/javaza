package pl.juglodz.notatnik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpException;

public class MyHttpManger implements HttpManager {

	private UpdateProgressCallback progress;

	@Override
	public String load(String urlt, UpdateProgressCallback progress) throws HttpException {
		this.progress = progress;
		try {
			URL url = new URL(urlt);
			progress.onProgress(20);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			progress.onProgress(25);
			return readStream(con.getInputStream());
		} catch (Exception e) {
			throw new HttpException("error when download webside", e);
		}
	}

	private String readStream(InputStream in) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			String strona = "";
			int i = 25;
			while ((line = reader.readLine()) != null) {
				progress.onProgress(++i);
				if (i>75){
					i = 25;
				}
				strona += line;
			}
			return strona;
		} catch (IOException e) {
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
