package info.kyorohiro.helloworld.testsample.test.test.testcase;

import info.kyorohiro.helloworld.testsample.test.TestTargetPreferenceFragment;
import info.kyorohiro.helloworld.testsample.test.test.TestActivity;
import info.kyorohiro.helloworld.testsample.test.test.TestActivity.OnCreate;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.LinearLayout;

public class TestCaseSample extends ActivityInstrumentationTestCase2<TestActivity>{

	public TestCaseSample() {
		super(TestActivity.class.getPackage().toString(), TestActivity.class);
	}

	public void testSampleStartActivity() {
		try {
			android.util.Log.v("testsample","called testSampleStartActivity()");
			getInstrumentation().waitForIdleSync();
			
			TestActivity.setOnCreate(new OnCreate() {
				public void onCreate(Activity target, Bundle savedInstanceState) {
					LinearLayout layout = new LinearLayout(target);
					target.setContentView(layout);
					layout.setId(3001);
					FragmentManager m = target.getFragmentManager();
					FragmentTransaction t = m.beginTransaction();
					Fragment f1 = new TestTargetPreferenceFragment();
					t.add(layout.getId(),f1, "f1");
					t.show(f1);
					t.commit();
				}

			});
			android.util.Log.v("testsample","startActivity()");
			getActivity();

			getInstrumentation().waitForIdleSync();
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
