package mobappdev.demo.finalexam.problem1;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Tkha on 6/29/17.
 */


public class LifecycleLogger extends AppCompatActivity{

    // gets the name of current class
    protected final String TAG = getClass().getName();

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: first activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: first activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: first activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: first activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: first activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: first activity");
    }

}
