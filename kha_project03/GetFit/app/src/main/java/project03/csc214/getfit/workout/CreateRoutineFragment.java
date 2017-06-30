package project03.csc214.getfit.workout;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
public class CreateRoutineFragment extends Fragment {

    public static final String TAG = "CreateRoutineFrag";
    private Map<Integer, Day> mDays;
    private Calendar mCalendar;
    private EditText etRoutine;
    private Day mCurrentDay;
    private int day_of_week;
    private Button bSubmit;



    public CreateRoutineFragment() {
        // Required empty public constructor
    }

    public interface CreateListener {
        public void createDay(CharSequence message);
    }

    private CreateListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CreateListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (CreateListener)activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_routine, container, false);
        etRoutine = (EditText)view.findViewById(R.id.routine_create);
        bSubmit = (Button)view.findViewById(R.id.creat_submit);
        Log.i(TAG, "onCreateView: Created");

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.createDay(etRoutine.getText());
            }
        });

        return view;
    }

}
