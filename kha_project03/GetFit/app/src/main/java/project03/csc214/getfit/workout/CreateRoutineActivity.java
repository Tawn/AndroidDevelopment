package project03.csc214.getfit.workout;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import project03.csc214.getfit.R;
import project03.csc214.getfit.database.Database;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;

public class CreateRoutineActivity extends AppCompatActivity implements CreateRoutineFragment.CreateListener {
    
    public static final String TAG = "Create Routine Activity";
    private CreateRoutineFragment fragment;
    private Map<Integer, Day> mDays;
    private Calendar mCalendar;
    private Day mCurrentDay;
    private int day_of_week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routine);

        // Updated schedule
        List<Day> dbDays = Database.get(getApplicationContext()).getDays();
        WeekProgress progress = new WeekProgress();
        mDays = progress.update(dbDays);

        // Get current day
        mCalendar = Calendar.getInstance();
        day_of_week = mCalendar.get(Calendar.DAY_OF_WEEK);
        mCurrentDay = mDays.get(day_of_week);

        // Start new Intent
        Intent intent = new Intent(this, WorkoutActivity.class);
        if(!mCurrentDay.getRoutine().equals("No Scheduled Workout")) {
            Log.i(TAG, "onCreate: Schedule Exists: " + mCurrentDay.getRoutine());
            startActivity(intent);
            
        }
        // Start Fragment
        fragment = new CreateRoutineFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.create_routine_frame, fragment)
                .commit();
    }

    public void cancelButtonPress(View view) {
        finish();
    }

    @Override
    public void createDay(CharSequence message) {
        Day day = new Day();
        day.setRoutine(message.toString());
        day.setDay(day_of_week);
        Database.get(getApplicationContext()).addDay(day);
        Log.i(TAG, "createDay:  new dayyy: " + day.getRoutine() + day.getDay());
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);

    }
}
