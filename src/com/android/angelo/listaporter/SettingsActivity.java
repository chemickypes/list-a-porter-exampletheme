package com.android.angelo.listaporter;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setNavigationBar();
		getFragmentManager().beginTransaction().replace(android.R.id.content,
                new SettingsFragment()).commit();
	}
	
	private void setNavigationBar(){
		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
	}

	

}
