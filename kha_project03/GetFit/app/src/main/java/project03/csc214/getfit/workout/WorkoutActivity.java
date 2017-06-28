package project03.csc214.getfit.workout;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import project03.csc214.getfit.HomeActivity;
import project03.csc214.getfit.R;

public class WorkoutActivity extends AppCompatActivity {

    private WorkoutFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        fragment = new WorkoutFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.workout_frame, fragment)
                .commit();

    }

    // No args passed
    // Set database
    public void finishButtonPress(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
