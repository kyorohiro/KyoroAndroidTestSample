package info.kyorohiro.helloworld.testsample.test;

import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceActivity.Header;
import android.preference.PreferenceFragment;

public class TestTargetWithFragmentActivity extends PreferenceActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*
        FragmentManager m = getFragmentManager();
        FragmentTransaction t = m.beginTransaction();
        t.add(new TestTargetPreferenceFragment(), "aa");
        t.commit();
//        setContentView(R.layout.main);*/
 
    }

///*
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref2, target);
    }
//*/
}