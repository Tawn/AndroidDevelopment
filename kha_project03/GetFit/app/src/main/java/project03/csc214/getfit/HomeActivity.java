package project03.csc214.getfit;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import project03.csc214.getfit.pager.PagerAdapter;
import project03.csc214.getfit.workout.CreateRoutineActivity;

// HOME - start routine
// ROUTINE - list of workouts with weights
// SETTINGS - edit weekly routines and weights
public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "Home";
    private ViewPager mPager;
    private PagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // ViewPager
        mAdapter = new PagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(1);

    }

    public void startButtonPress(View view) {
        Log.i(TAG, "startButtonPress: test");
        Intent intent = new Intent(this, CreateRoutineActivity.class);
        startActivity(intent);
    }

}
