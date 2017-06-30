package project03.csc214.getfit.setting;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

// Set information
public class SettingsFragment extends Fragment {

    private EditText etNote, etWorkout;
    private Map<Integer, Day> mDays;
    private Button bSave;
    private int day;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public interface SettingsListener {
        public void saveChanges();
    }

    private SettingsListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (SettingsListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (SettingsListener)activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_settings, container, false);

        // Updated schedule
        final List<Day> dbDays = Database.get(getContext()).getDays();
        WeekProgress progress = new WeekProgress();
        mDays = progress.update(dbDays);

        // Update EditTexts
        Calendar c = Calendar.getInstance();
        etWorkout = (EditText)view.findViewById(R.id.edit_workout);
        etNote = (EditText)view.findViewById(R.id.edit_note);
        day = c.get(Calendar.DAY_OF_WEEK);
        etWorkout.setText(mDays.get(day).getRoutine());
        etNote.setText(mDays.get(day).getNote());

        bSave = (Button)view.findViewById(R.id.setting_save);
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.saveChanges();
                String note = etNote.getText().toString();
                mDays.get(day).setNote(note);
                Database.get(getContext()).addDay(mDays.get(day));
            }
        });
        return view;
    }

}
