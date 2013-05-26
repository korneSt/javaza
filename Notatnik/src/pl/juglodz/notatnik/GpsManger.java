package pl.juglodz.notatnik;

import android.location.Location;
import android.location.LocationListener;

public interface GpsManger {

	public void getCurrentLocation(LocationListener locationListener); 
	
}
