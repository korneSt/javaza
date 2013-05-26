package pl.juglodz.notatnik;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends Activity {
	
	private EditText tytulET;
	private EditText notataET;
	private Button zapiszButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_note);
		tytulET = (EditText) findViewById(R.id.tytul_edit_text);
		notataET = (EditText) findViewById(R.id.notatka_edit_text);
		zapiszButton = (Button) findViewById(R.id.zapisz_button);
	}

}
