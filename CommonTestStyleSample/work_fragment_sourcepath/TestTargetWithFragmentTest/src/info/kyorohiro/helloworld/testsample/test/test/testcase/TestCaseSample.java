package info.kyorohiro.helloworld.testsample.test.test.testcase;

import java.lang.reflect.Method;

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
			final TestTargetPreferenceFragment[] f1 = new TestTargetPreferenceFragment[1];
			TestActivity.setOnCreate(new OnCreate() {
				public void onCreate(Activity target, Bundle savedInstanceState) {
					LinearLayout layout = new LinearLayout(target);
					target.setContentView(layout);
					layout.setId(3001);
					FragmentManager m = target.getFragmentManager();
					FragmentTransaction t = m.beginTransaction();
					/*Fragment */f1[0] = new TestTargetPreferenceFragment();
					t.add(layout.getId(),f1[0], "f1");
					t.show(f1[0]);
					t.commit();
				}

			});
			android.util.Log.v("testsample","startActivity()");
			getActivity();

			getInstrumentation().waitForIdleSync();

			try {
				Class <?> c = Class.forName("info.kyorohiro.helloworld.testsample.test.TestTargetPreferenceFragment");
				Method mth = c.getDeclaredMethod("getRingtone", Activity.class);
 				Method mthWrong = c.getDeclaredMethod("getRingtone");
				mth.setAccessible(true);
				String mode = (String)mth.invoke(c.newInstance(), new Object[]{ getActivity()});
				android.util.Log.v("kiyo","mode A="+mode);
				mode = (String)mthWrong.invoke(f1[0]);
				android.util.Log.v("kiyo","mode B="+mode);

				mode = (String)mthWrong.invoke(c.newInstance());
				android.util.Log.v("kiyo","mode C="+mode);

			} catch(Exception e ){
				e.printStackTrace();
			}
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
