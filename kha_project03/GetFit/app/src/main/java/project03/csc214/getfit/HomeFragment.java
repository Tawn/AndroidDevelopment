package project03.csc214.getfit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import project03.csc214.getfit.database.Database;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tvDay;
    private TextView tvRoutine;
    private Map<Integer, Day> mDays;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Calender day
        tvDay = (TextView)view.findViewById(R.id.day_of_week);
        tvRoutine = (TextView)view.findViewById(R.id.home_routine);
        setDay();
        return view;
    }

    public void setDay() {
        // Updated schedule
        List<Day> dbDays = Database.get(getContext()).getDays();
        WeekProgress progress = new WeekProgress();
        mDays = progress.update(dbDays);


        // Update TextView
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        tvDay.setText(mDays.get(day).getDay());
        tvRoutine.setText(mDays.get(day).getRoutine());
    }

}
