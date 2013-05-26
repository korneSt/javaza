package pl.juglodz.notatnik;

import pl.juglodz.notatnik.data.Notatka;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends Activity implements OnClickListener {
	
	private EditText tytulET;
	private EditText notataET;
	private Button zapiszButton;
	private ZapisywaczNotatek zapisywacz;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_note);
		tytulET = (EditText) findViewById(R.id.tytul_edit_text);
		notataET = (EditText) findViewById(R.id.notatka_edit_text);
		zapiszButton = (Button) findViewById(R.id.zapisz_button);
		zapiszButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Notatka notatka = new Notatka();
		String tytul = tytulET.getText().toString();
		String tresc = notataET.getText().toString();
		long time =  System.currentTimeMillis();
		notatka.setTitle(tytul);
		notatka.setTresc(tresc);
		notatka.setOstatniaZmiana(time);
		
	}

}
