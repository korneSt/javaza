package pl.juglodz.notatnik;

import java.util.List;

import pl.juglodz.notatnik.data.LinkDTO;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LinkSearcherActivity extends Activity implements OnClickListener, LinkCallback {
	
	private Button startButton;
	private ListView listaLinkView;
	private AsynLinkLoader linkLoader;
	private EditText linkET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.link_main);
		startButton = (Button) findViewById(R.id.nowaNotatkaButton);
		listaLinkView = (ListView) findViewById(R.id.listaNotatekView);
		linkET = (EditText) findViewById(R.id.link_editText);
		startButton.setOnClickListener(this);
		linkLoader = new AsynLinkLoaderImpl();
	}

	@Override
	public void onClick(View arg0) {
		linkLoader.getAllLinks(Uri.parse(linkET.getText().toString()), this);
	}

	@Override
	public void zakonczona(List<LinkDTO> lista) {
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		for (LinkDTO linkDTO : lista) {
			adapter.add(linkDTO.toString());
		}
		listaLinkView.setAdapter(adapter);
	}

}
