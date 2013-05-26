package pl.juglodz.notatnik;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class LinkSearcherActivity extends Activity implements OnClickListener {
	
	private Button startButton;
	private ListView listaLinkView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.link_main);
		startButton = (Button) findViewById(R.id.nowaNotatkaButton);
		listaLinkView = (ListView) findViewById(R.id.listaNotatekView);
		startButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		
	}

}
