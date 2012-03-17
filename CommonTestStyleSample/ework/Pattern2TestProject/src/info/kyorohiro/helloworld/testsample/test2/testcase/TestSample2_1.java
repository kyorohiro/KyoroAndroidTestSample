package info.kyorohiro.helloworld.testsample.test2.testcase;

import info.kyorohiro.helloworld.testsample.test2.Pattern2TestProjectActivity;
import android.test.ActivityInstrumentationTestCase2;

public class TestSample2_1 extends ActivityInstrumentationTestCase2<Pattern2TestProjectActivity>{

	public TestSample2_1() {
		super(Pattern2TestProjectActivity.class.getPackage().toString(),Pattern2TestProjectActivity.class);
	}
	public void testSampleStartActivity() {
		try {
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
