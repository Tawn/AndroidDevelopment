package assignment08.csc214.mytracks;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import assignment08.csc214.mytracks.RecyclerView.TrackFragment;

public class MainActivity extends AppCompatActivity implements TrackFragment.SoundMessageListener {

    public static final String TAG = "Main Activity";
    private static final String KEY = "KEY_MESSAGE";
    private String mSoundmessage;
    private TextView soundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: invoked");
        FragmentManager manager = getSupportFragmentManager();
        TrackFragment fragment = (TrackFragment)manager.findFragmentById(R.id.main_frame);

        if(fragment == null) {
            Log.i(TAG, "onCreate: Fragment created");
            fragment = new TrackFragment();
            manager.beginTransaction()
                    .add(R.id.main_frame, fragment)
                    .commit();
        }
        soundView = (TextView)findViewById(R.id.sound_view);
        mSoundmessage = soundView.getText().toString();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: saving message");
        outState.putString(KEY, mSoundmessage);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: restoring message");
        mSoundmessage = savedInstanceState.getString(KEY);
        soundView = (TextView)findViewById(R.id.sound_view);
        soundView.setText(mSoundmessage);
    }

    @Override
    public void soundChange(CharSequence message) {
        Log.i(TAG, "soundChange: Sound listener invoked");
        mSoundmessage = message.toString();
        TextView soundView = (TextView)findViewById(R.id.sound_view);
        soundView.setText(message);
    }
}
