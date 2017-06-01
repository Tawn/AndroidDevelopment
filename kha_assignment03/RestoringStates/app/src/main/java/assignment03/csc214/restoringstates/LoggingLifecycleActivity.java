package assignment03.csc214.restoringstates;

import android.media.Image;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LoggingLifecycleActivity extends AppCompatActivity {

    // Variables
    private String TAG;
    private TextView mEditText;
    private ImageView mEditImage;
    private ImageButton mImageButton;
    private boolean isBasset;
    private int rotateCount;
    private String rotateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_lifecycle);

        // Initializing Variables
        TAG = "Thanh";
        Log.d(TAG, "Creating");
        isBasset = true;
        rotateCount = 0;
        mEditImage = (ImageView)findViewById(R.id.image_edit);
        mImageButton = (ImageButton)findViewById(R.id.butt_image);
        mEditText = (TextView)findViewById(R.id.text_edit);
        rotateDisplay = "Screen Rotated: ";
    }


    // Button listener
    public void imageChangerButton(View view) {

        if(isBasset) { // If current image is a Basset Hound
            mEditImage.setImageResource(R.drawable.lab);
            mImageButton.setImageResource(R.drawable.basset);
            isBasset = false;

        } else { // If it's a Lab
            mEditImage.setImageResource(R.drawable.basset);
            mImageButton.setImageResource(R.drawable.lab);
            isBasset = true;
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        rotateCount++;

        // Saving important on close
        savedInstanceState.putInt("rotateCount", rotateCount); // rotate count
        savedInstanceState.putBoolean("isBasset", isBasset);   // image and button state


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore Count
        rotateCount = savedInstanceState.getInt("rotateCount");
        mEditText.setText(rotateDisplay + rotateCount);

        // Restore Button and Image State
        isBasset = savedInstanceState.getBoolean("isBasset");
        if(isBasset) {
            mEditImage.setImageResource(R.drawable.basset);
            mImageButton.setImageResource(R.drawable.lab);
        } else {
            mEditImage.setImageResource(R.drawable.lab);
            mImageButton.setImageResource(R.drawable.basset);
        }
    }

    // Log Indicator
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Resumed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Paused");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Restarted");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Destroyed");

    }

}
