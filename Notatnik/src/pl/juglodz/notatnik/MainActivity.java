package pl.juglodz.notatnik;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener, LocationListener {

	private Button nowaNotatkaButton;
	private ListView listaNotatekView;
	private GpsManger gpsManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nowaNotatkaButton = (Button) findViewById(R.id.nowaNotatkaButton);
		listaNotatekView = (ListView) findViewById(R.id.listaNotatekView);
		nowaNotatkaButton.setOnClickListener(this);
		gpsManager = new AndroidGpsManager(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// Intent intent = new Intent(this, NewNoteActivity.class);
		// startActivity(intent);
		gpsManager.getCurrentLocation(this);

		
	}

	@Override
	public void onLocationChanged(Location location) {
		nowaNotatkaButton.setText(location.getLatitude() + " "
				+ location.getLongitude());
	}

	@Override
	public void onProviderDisabled(String provider) {
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		
	}

}
