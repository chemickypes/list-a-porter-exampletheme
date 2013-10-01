package com.android.angelo.listaporter;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.util.Log;

public class SettingsFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public void onResume(){
		super.onResume();
		setPreferences();
	}
	
	
	private void setPreferences(){
		addPreferencesFromResource(R.xml.settings_preferences);
		final ListPreference lpr = (ListPreference) findPreference("colors");
		final String[] colors = getResources().getStringArray(R.array.colors);
		lpr.setSummary("Color Name is "+ lpr.getValue());
		Log.d("settings", "firts list");
		lpr.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				lpr.setSummary("Color Name is "+ colors[Integer.parseInt((String)newValue)-1]);
				lpr.setDefaultValue(colors[Integer.parseInt((String)newValue)-1]);
				return true;
			}
		});
		
		final ListPreference lpr2 = (ListPreference) findPreference("formatdata");
		final String[] format = getResources().getStringArray(R.array.formatdate);
		lpr2.setSummary(lpr2.getValue()+" format");
		Log.d("settings", "second list");
		lpr2.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				lpr2.setSummary(format[Integer.parseInt((String)newValue)-1]+" format");
				lpr2.setDefaultValue(format[Integer.parseInt((String)newValue)-1]);
				return true;
			}
		});
		
		final ListPreference lpr3 = (ListPreference) findPreference("themes");
		final String[] themes = getResources().getStringArray(R.array.themes);
		lpr3.setSummary(themes[Integer.parseInt(lpr3.getValue())]+" theme");
		lpr3.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				lpr3.setSummary(themes[Integer.parseInt((String)newValue)]+" theme");
				lpr3.setDefaultValue(themes[Integer.parseInt((String)newValue)]);
				return true;
			}
		});
	}
}
