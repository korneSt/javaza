package pl.juglodz.notatnik;

import java.util.List;

import pl.juglodz.notatnik.data.LinkDTO;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LinkSearcherActivity extends Activity implements OnClickListener, LinkCallback, OnItemClickListener {
	
	private Button startButton;
	private ListView listaLinkView;
	private AsynLinkLoader linkLoader;
	private EditText linkET;
	private ProgressBar progressBar;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.link_main);
		startButton = (Button) findViewById(R.id.nowaNotatkaButton);
		listaLinkView = (ListView) findViewById(R.id.listaNotatekView);
		linkET = (EditText) findViewById(R.id.link_editText);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		startButton.setOnClickListener(this);
		linkLoader = new AsynLinkLoaderImpl();
		progressBar.setMax(100);
		listaLinkView.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		linkLoader.getAllLinks(Uri.parse(linkET.getText().toString()), this);
	}

	@Override
	public void zakonczona(List<LinkDTO> lista) {
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		for (LinkDTO linkDTO : lista) {
			adapter.add(linkDTO.toString());
		}
		listaLinkView.setAdapter(adapter);
	}

	@Override
	public void onError(String messge) {
		Toast.makeText(this, messge, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProgress(int ile) {
		progressBar.setProgress(ile);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		String url = adapter.getItem(position);
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}

}
