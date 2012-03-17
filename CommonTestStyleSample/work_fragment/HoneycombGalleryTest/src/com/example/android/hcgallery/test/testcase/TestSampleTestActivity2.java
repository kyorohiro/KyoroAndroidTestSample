package com.example.android.hcgallery.test.testcase;

import com.example.android.hcgallery.R;
import com.example.android.hcgallery.test.TestActivity;
import com.example.android.hcgallery.test.TestActivity.OnCreate;
import com.example.android.hcgallery.test.TestActivity2;

import android.app.Activity;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;

public class TestSampleTestActivity2 extends ActivityInstrumentationTestCase2<TestActivity2>{

	public TestSampleTestActivity2() {
		super(TestActivity2.class.getPackage().toString(), TestActivity2.class);
	}

	public void testSampleStartActivity() {
		try {
			TestActivity.setOnCreate(new OnCreate(){
				public void onCreate(Activity target, Bundle savedInstanceState) {
					target.setContentView(R.layout.main);
				}
			});
			android.util.Log.v("testsample","called testSampleStartActivity()");
			Thread.sleep(3000);
			
			android.util.Log.v("testsample","startActivity()");
			getActivity();
			
			android.util.Log.v("testsample","sleep 5 sec");
			Thread.sleep(5000);			

			assertTrue("good!!", true);
		} catch(InterruptedException e) {
			// don't pass along this route.
			e.printStackTrace();
			assertTrue("???", false);
		}
	}
}
