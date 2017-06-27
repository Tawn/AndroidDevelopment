package project03.csc214.getfit.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import project03.csc214.getfit.HomeFragment;
import project03.csc214.getfit.schedule.ScheduleFragment;
import project03.csc214.getfit.setting.SettingsFragment;

/**
 * Created by Tkha on 6/27/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public static final String TAG = "PageerAdapter";
    private List<Fragment> mFragments;
    ScheduleFragment schedFragment = new ScheduleFragment();
    HomeFragment hFragment = new HomeFragment();
    SettingsFragment sFragment = new SettingsFragment();
    // Calender day
    Calendar c = Calendar.getInstance();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        Log.i(TAG, "PagerAdapter: Constructor invoked");
        mFragments = new ArrayList<>();
        mFragments.add(schedFragment);
        mFragments.add(hFragment);
        mFragments.add(sFragment);

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}