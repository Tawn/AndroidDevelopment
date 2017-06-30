package project03.csc214.getfit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Calendar;
import java.util.List;

import project03.csc214.getfit.database.Database;
import project03.csc214.getfit.extra.ExtraActivity;
import project03.csc214.getfit.model.Day;

import project03.csc214.getfit.pager.DialogViewFragment;
import project03.csc214.getfit.pager.PagerAdapter;
import project03.csc214.getfit.setting.SettingsFragment;
import project03.csc214.getfit.workout.CreateRoutineActivity;

public class HomeActivity extends AppCompatActivity implements SettingsFragment.SettingsListener{

    public static final String TAG = "Home";
    private ViewPager mPager;
    private PagerAdapter mAdapter;
    private List<Day> mDays;
    private Calendar cal;
    private int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDays = Database.get(getApplicationContext()).getDays();
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_WEEK);
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

    public void settingButtonPress(View view) {
        Log.i(TAG, "settingButtonPress: ");
        mPager.setCurrentItem(2);
    }

    public void scheduleButtonPress(View view) {
        mPager.setCurrentItem(0);
    }

    public void extraButtonPress(View view) {
        Intent intent = new Intent(this, ExtraActivity.class);
        startActivity(intent);
    }

    @Override
    public void saveChanges() {
        mPager.setCurrentItem(1);
    }
}
