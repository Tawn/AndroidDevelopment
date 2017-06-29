package project03.csc214.getfit.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import project03.csc214.getfit.R;
import project03.csc214.getfit.database.Database;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutFragment extends Fragment {

    private TextView tvWorkout;
    private Map<Integer, Day> mDays;

    public WorkoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        // Updated schedule
        List<Day> dbDays = Database.get(getContext()).getDays();
        WeekProgress progress = new WeekProgress();
        mDays = progress.update(dbDays);

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);

        // Set TextView
        tvWorkout = (TextView)view.findViewById(R.id.tv_workout_fragment);
        tvWorkout.setText(mDays.get(day).getRoutine());
        return view;
    }

}
