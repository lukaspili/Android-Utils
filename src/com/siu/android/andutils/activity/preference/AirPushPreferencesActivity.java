package com.siu.android.andutils.activity.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.siu.android.andutils.R;

/**
 * User: Jonathan TRIBOUHARET
 * Date: 18/04/12
 * Time: 19:15
 */
public abstract class AirPushPreferencesActivity extends BasicSherlockPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getPreferenceManager().getSharedPreferences();
        if (!preferences.contains(getString(R.string.preferences_ads_airpush_enabled))) {
            preferences.edit().putBoolean(getString(R.string.preferences_ads_airpush_enabled), true).commit();
        }
    }
}
