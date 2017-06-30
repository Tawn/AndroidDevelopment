package project03.csc214.getfit.workout;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import project03.csc214.getfit.HomeActivity;
import project03.csc214.getfit.R;
import project03.csc214.getfit.pager.DialogViewFragment;

public class WorkoutActivity extends AppCompatActivity implements WorkoutFragment.CompleWorkoutListener {

    public static final String TAG = "Workout Activity";
    private WorkoutFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Log.i(TAG, "onCreate: Activity created");
        fragment = new WorkoutFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.workout_frame, fragment)
                .commit();
        Toast.makeText(getApplicationContext(), "Workout Saved", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void finishWorkout() {

    }
}
