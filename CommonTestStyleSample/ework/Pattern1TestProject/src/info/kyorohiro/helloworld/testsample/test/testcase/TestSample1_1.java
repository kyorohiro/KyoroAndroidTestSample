package info.kyorohiro.helloworld.testsample.test.testcase;

import info.kyorohiro.helloworld.testsample.TestTargetActivity;
import android.test.ActivityInstrumentationTestCase2;

public class TestSample1_1 extends ActivityInstrumentationTestCase2<TestTargetActivity>{

	public TestSample1_1() {
		super(TestTargetActivity.class.getPackage().toString(), TestTargetActivity.class);
//		super(null, TestTargetActivity.class);
	}
	
	
	public void testSampleStartActivity() {
		try {
			android.util.Log.v("testsample","called testSampleStartActivity()");
			Thread.sleep(3000);
			
			android.util.Log.v("testsample","startActivity()");
			getActivity();
			
			android.util.Log.v("testsample","sleep 8 sec");
			Thread.sleep(8000);			

			assertTrue("good!!", true);
		} catch(InterruptedException e) {
			// don't pass along this route.
			e.printStackTrace();
			assertTrue("???", false);
		}
		
	}
}
