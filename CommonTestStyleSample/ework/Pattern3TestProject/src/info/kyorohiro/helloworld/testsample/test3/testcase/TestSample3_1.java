package info.kyorohiro.helloworld.testsample.test3.testcase;

import info.kyorohiro.helloworld.testsample.test3.Pattern3TestProjectActivity;
import info.kyorohiro.helloworld.testsample.test3.Pattern3TestProjectActivity.OnCreate;
import info.kyorohiro.helloworld.testsample.util.HelloProperty;
import android.app.Activity;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class TestSample3_1 extends ActivityInstrumentationTestCase2<Pattern3TestProjectActivity>{

	public TestSample3_1() {
		super(Pattern3TestProjectActivity.class.getPackage().toString(), Pattern3TestProjectActivity.class);
	}

	public void testSampleStartActivity() {
		try {
			Pattern3TestProjectActivity.setOnCreate(new OnCreate(){
				@Override
				public void onCreate(Activity target, Bundle savedInstanceState) {
					TextView message = new TextView(target);
					HelloProperty property = new HelloProperty();
					int id = info.kyorohiro.helloworld.testsample.R.string.app_name;
//                  following is NotFoundException
//					int id = info.kyorohiro.helloworld.testsample.R.string.option;
					String targetAppName = target.getResources().getString(id);
					message.setText("HelloPropery return " + property.getHello() + ":" + targetAppName);
					target.setContentView(message);
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
