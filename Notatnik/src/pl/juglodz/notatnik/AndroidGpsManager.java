package pl.juglodz.notatnik;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;

public class AndroidGpsManager implements GpsManger {

	private Context mContext;
	private LocationManager locationManager;

	public AndroidGpsManager(Context context) {
		this.mContext = context;
	}

	@Override
	public void getCurrentLocation(LocationListener locationListener) {
		locationManager = (LocationManager) mContext
				.getSystemService(Context.LOCATION_SERVICE);
		// getting GPS status
		Criteria crit = new Criteria();
		crit.setAccuracy(Criteria.ACCURACY_FINE);
		String provider = locationManager.getBestProvider(crit, true);
		try {
			Thread.sleep(13000);
		} catch (InterruptedException e) {
		}
		locationManager.requestLocationUpdates(provider, 100, 1,
				locationListener);
	}

}
