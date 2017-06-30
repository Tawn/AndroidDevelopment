package project03.csc214.getfit.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project03.csc214.getfit.database.Database;

/**
 * Created by Tkha on 6/27/17.
 */

public class WeekProgress {

    private Map<Integer, Day> mProgress;
    private Map<String, Workout> mWorkouts;

    public WeekProgress() {
        mProgress = new HashMap<>();
        Day sun = new Day();
        Day mon = new Day();
        Day tue = new Day();
        Day wed = new Day();
        Day thur = new Day();
        Day fri = new Day();
        Day sat = new Day();

        sun.setDay(1);
        mon.setDay(2);
        tue.setDay(3);
        wed.setDay(4);
        thur.setDay(5);
        fri.setDay(6);
        sat.setDay(7);

        mProgress.put(1, sun);
        mProgress.put(2, mon);
        mProgress.put(3, tue);
        mProgress.put(4, wed);
        mProgress.put(5, thur);
        mProgress.put(6, fri);
        mProgress.put(7, sat);
    }

    public Map<Integer, Day> update(List<Day> dbDays) {
        for(int i = 0; i < dbDays.size(); i++) {
            Day d = dbDays.get(i);
            mProgress.put(d.getDayNumber(), d);
        }
        return mProgress;

    }


    public List<Day> getDays() {
        List<Day> list = new ArrayList<>();
        list.addAll(mProgress.values());
        return list;
    }

    public Day getDay() {
        Calendar day = Calendar.getInstance();
        return mProgress.get(day);
    }
}
