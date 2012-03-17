package com.example.android.hcgallery.test;

import android.app.Activity;
import android.graphics.AvoidXfermode;
import android.os.Bundle;

public class TestActivity extends Activity {

	private static OnCreate mCreate = null;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mCreate != null) {
        	mCreate.onCreate(this, savedInstanceState);
        } else {
        	android.util.Log.v("testsample","mCreate is null");
        	setContentView(R.layout.main);
        }
    }

    public static void setOnCreate(OnCreate creator) {
    	mCreate = creator;
    }

    public static interface OnCreate {
        void onCreate(Activity target, Bundle savedInstanceState);    	
    }
}
