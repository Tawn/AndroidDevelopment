package assignment05.csc214.fragmenting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TopFragment.TopMessageListener{


    public static final String INPUT_KEY = "INPUT_MESSAGE";
    public String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Top Fragment Button Press
    @Override
    public void messageSentDown(CharSequence message) {
        Log.d(TAG , "messageSentDown: Called");

        // Creating Bundle to transfer to Bottom Fragment
        BottomFragment mBottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString(INPUT_KEY, message.toString());
        mBottomFragment.setArguments(bundle);

        // Creating Bottom Fragment
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fl_bottom, mBottomFragment)
                .commit();
    }

    // Main Activity Button Press
    public void submitButtonPress(View view) {
        EditText mTextInput = (EditText)findViewById(R.id.et_input);

        // Creating Bundle to transfer to Top Fragment
        Bundle bundle = new Bundle();
        bundle.putString(INPUT_KEY, mTextInput.getText().toString());
        TopFragment mTopFragment = new TopFragment();
        mTopFragment.setArguments(bundle);

        // Creating Fragment
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fl_top, mTopFragment)
                .commit();

    }


}
