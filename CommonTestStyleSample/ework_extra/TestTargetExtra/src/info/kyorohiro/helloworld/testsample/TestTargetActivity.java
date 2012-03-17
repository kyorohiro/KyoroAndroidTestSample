package info.kyorohiro.helloworld.testsample;

import info.kyorohiro.helloworld.testsample.extra.R;
import android.app.Activity;
import android.os.Bundle;

public class TestTargetActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}