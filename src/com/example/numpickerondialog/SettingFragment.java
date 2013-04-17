package com.example.numpickerondialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

public class SettingFragment extends PreferenceFragment implements
		OnPreferenceChangeListener, OnPreferenceClickListener {

	private NumberPicker _np;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);


		final PreferenceScreen datepf = (PreferenceScreen) findPreference("");
		datepf.setOnPreferenceClickListener(this);


	}


	@Override
	public boolean onPreferenceClick(Preference preference) {
		if (preference.getKey().equals("")) {
			showDialog();
			return true;
		}
		return false;
	}

	/**
	 * NumberPickerのダイアログを生成
	 */
	private void showDialog() {
		class MainFragmentDialog extends DialogFragment {
	        @Override
	        public Dialog onCreateDialog(Bundle savedInstanceState) {
	            LayoutInflater inflater = getActivity().getLayoutInflater();
	            View view = inflater.inflate(R.layout.setting_dialog, null, false);

	            _np = (NumberPicker)view.findViewById(R.id.numberPicker);
	            _np.setMaxValue(31);
	            _np.setMinValue(1);

	            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	            builder.setTitle("Number Picker");
	            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						//OKクリック時の処理
					}
				});
	            builder.setNegativeButton("Cancel", null);
	            builder.setView(view);
	            return builder.create();
	        }
	    }

		//Dialogの表示
		MainFragmentDialog dialog = new MainFragmentDialog();
		dialog.show(getFragmentManager(), "span_setting_dialog");
	}


	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
