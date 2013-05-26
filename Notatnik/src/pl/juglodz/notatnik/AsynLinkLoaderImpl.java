package pl.juglodz.notatnik;

import java.util.List;

import pl.juglodz.notatnik.data.LinkDTO;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

public class AsynLinkLoaderImpl implements AsynLinkLoader {

	protected static final String TAG = "AsynLinkLoaderImpl";
	LinkLoader linkLoader;
	
	public AsynLinkLoaderImpl() {
		linkLoader = new MyLinkLoader();
	}
	@Override
	public void getAllLinks(final Uri webside,final LinkCallback callback) {
		new AsyncTask<Uri, Integer, List<LinkDTO>>() {

			@Override
			protected List<LinkDTO> doInBackground(Uri... params) {
				Log.d(TAG, Thread.currentThread().getName());
				return linkLoader.getAllLinks(webside);
			}
			
			@Override
			protected void onPostExecute(List<LinkDTO> result) {
				super.onPostExecute(result);
				callback.zakonczona(result);
				Log.d(TAG, Thread.currentThread().getName());
			}
		};
	}

}
