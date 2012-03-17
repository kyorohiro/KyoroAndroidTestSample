package info.kyorohiro.helloworld.testsample.test;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class TestTargetPreferenceFragment extends PreferenceFragment {
    static final String SHARED_PREFS_NAME = "RobotSpeakSettings";
    static final String WHISPER_KEY = "robot_speak_whisper";
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName(SHARED_PREFS_NAME);
        addPreferencesFromResource(R.xml.pref);
	}
}
