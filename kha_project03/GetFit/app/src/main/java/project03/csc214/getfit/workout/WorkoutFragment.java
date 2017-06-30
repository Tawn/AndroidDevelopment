package project03.csc214.getfit.workout;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import project03.csc214.getfit.R;
import project03.csc214.getfit.database.Database;
import project03.csc214.getfit.database.DatabaseHelper;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;
import project03.csc214.getfit.model.Workout;
import project03.csc214.getfit.pager.DialogViewFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutFragment extends Fragment {

    public static final String TAG = "Workout Frag";
    private TextView tvWorkout;
    private Map<Integer, Day> mDays;
    private Button bFinish;
    private EditText etNotes;
    private Calendar c;
    private int day;
    private View view2;

    public WorkoutFragment() {
        // Required empty public constructor
    }

    public interface CompleWorkoutListener {
        public void finishWorkout();
    }

    private CompleWorkoutListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CompleWorkoutListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (CompleWorkoutListener)activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        view2 = view;
        Log.i(TAG, "onCreateView: fragment inflated");

        // Updated schedule
        List<Day> dbDays = Database.get(getContext()).getDays();
        WeekProgress progress = new WeekProgress();
        mDays = progress.update(dbDays);

        c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_WEEK);

        // Set TextView
        tvWorkout = (TextView)view.findViewById(R.id.tv_workout_fragment);
        tvWorkout.setText(mDays.get(day).getRoutine());

        bFinish = (Button)view.findViewById(R.id.workout_finish);

        // When Finished -> Store workout results
        bFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeResult();

            }
        });

        // Set EditText
        etNotes = (EditText)view.findViewById(R.id.workout_note);
        etNotes.setText(mDays.get(day).getNote());

        return view;
    }

    public void storeResult() {
        String note = ((EditText)view2.findViewById(R.id.workout_note)).getText().toString();
        Day dayEdit = mDays.get(day);
        dayEdit.setNote(note);
        Database.get(getContext()).addDay(dayEdit);

        // Display dialog
        DialogViewFragment dialog = new DialogViewFragment()
                .newInstance(mDays.get(day));
        dialog.setTargetFragment(WorkoutFragment.this, 2);
        dialog.show(getFragmentManager(), "test");
        mListener.finishWorkout();

    }

}
