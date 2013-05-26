package pl.juglodz.lottomanger;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import pl.juglodz.lottomanger.R; //zawsze
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private TextView numberDisplayer;
	private LottoAlgorytm lottoAlgorytm;
	private ListView listAlgorytm;

	private EditText ileLiczbET;
	private EditText maxLiczbaET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "onCreate");
		numberDisplayer = (TextView) findViewById(R.id.number_displayer_textview);
		listAlgorytm = (ListView) findViewById(R.id.list_algorytm);

		ileLiczbET = (EditText) findViewById(R.id.ile_liczb);
		maxLiczbaET = (EditText) findViewById(R.id.max_liczba);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		adapter.add("Duży lotek");
		adapter.add("Express lotek");
		adapter.add("SuperLotek");
		listAlgorytm.setAdapter(adapter);
		listAlgorytm.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> listView, View view,
					int position, long id) {

				switch (position) {
				case 0:
					lottoAlgorytm = new DuzyLottekAlgorytm();
					break;
				case 1:
					lottoAlgorytm = new ExpressLotekAlgorytm();
					break;
				case 2:
					try {
						lottoAlgorytm = new SuperAlgorytm(Integer
								.valueOf(ileLiczbET.getText().toString()), Integer
								.valueOf(maxLiczbaET.getText().toString()));
					} catch (NumberFormatException e) {
						Toast.makeText(MainActivity.this, "Podaj liczbbe ", Toast.LENGTH_SHORT).show();
						return;
					}
					break;
				default:
					break;
				}
				List<Integer> lista = lottoAlgorytm.losuj();
				Collections.sort(lista);
				numberDisplayer.setText("" + lista);
			}

		});
	}

}
