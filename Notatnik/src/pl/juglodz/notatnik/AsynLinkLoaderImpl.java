package pl.juglodz.notatnik;

import java.util.List;

import pl.juglodz.notatnik.data.LinkDTO;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

public class AsynLinkLoaderImpl implements AsynLinkLoader {

	protected static final String TAG = "AsynLinkLoaderImpl";
	
	public AsynLinkLoaderImpl() {
	}
	@Override
	public void getAllLinks(final Uri webside,final LinkCallback callback) {
		new MyAsyncTask(webside, callback).execute(webside);
	}

	private static class MyAsyncTask extends AsyncTask<Uri, Integer, List<LinkDTO>> implements UpdateProgressCallback{

		
		
		LinkLoader linkLoader;
		private Uri webside;
		private LinkCallback callback;
		public MyAsyncTask(Uri webside, LinkCallback callback) {
			this.webside = webside;
			this.callback = callback;
			linkLoader = new MyLinkLoader();
		}
		
		@Override
		protected List<LinkDTO> doInBackground(Uri... params) {
			Log.d(TAG, Thread.currentThread().getName());
			publishProgress(10);
			try {
				List<LinkDTO> list = linkLoader.getAllLinks(webside, this);
				publishProgress(100);
				return list;
			} catch (LoadException e) {
				cancel(true);
				return null;
			}
		}
		
		protected void onProgressUpdate(Integer[] values) {
			callback.onProgress(values[0]);
		};
		
		@Override
		protected void onPostExecute(List<LinkDTO> result) {
			super.onPostExecute(result);
			if (result==null){
				callback.onError("blad wczytania");
			}
			callback.zakonczona(result);
			Log.d(TAG, Thread.currentThread().getName());
		}

		@Override
		public void onProgress(int ile) {
			publishProgress(ile);
		}
		
	}
	
	
}
