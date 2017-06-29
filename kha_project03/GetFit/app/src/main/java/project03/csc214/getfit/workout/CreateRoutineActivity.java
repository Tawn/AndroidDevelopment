package project03.csc214.getfit.workout;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import project03.csc214.getfit.R;
import project03.csc214.getfit.database.Database;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;

public class CreateRoutineActivity extends AppCompatActivity {
    
    public static final String TAG = "Create Routine Activity";
    private CreateRoutineFragment fragment;
    private Map<Integer, Day> mDays;
    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routine);

        fragment = new CreateRoutineFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.create_routine_frame, fragment)
                .commit();

        // Updated schedule
        List<Day> dbDays = Database.get(getApplicationContext()).getDays();
        WeekProgress progress = new WeekProgress();
        mDays = progress.update(dbDays);

        // Get current day
        mCalendar = Calendar.getInstance();
        int c = mCalendar.get(Calendar.DAY_OF_WEEK);
        Day d = mDays.get(c);

        // Start new Intent
        Intent intent = new Intent(this, WorkoutActivity.class);
        if(d.getRoutine().equals("No Scheduled Workout")) {
            Log.i(TAG, "onCreate: No Schedule: " + d.getRoutine() + dbDays.size());

            
        } else {
            Log.i(TAG, "onCreate: Schedule Exists: " + d.getRoutine());
            startActivity(intent);
            
        }

        
    }

    public void submitButtonPress(View view) {
        Log.i(TAG, "submitButtonPress: ");
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    public void cancelButtonPress(View view) {
        finish();
    }
}
