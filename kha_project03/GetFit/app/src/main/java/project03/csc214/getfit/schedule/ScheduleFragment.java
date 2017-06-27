package project03.csc214.getfit.schedule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import project03.csc214.getfit.R;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;

// ListView - 7 days Settings
public class ScheduleFragment extends Fragment {

    private RecyclerView mView;
    private RecyclerAdapter adapter;
    private List<Day> mDays;
    private WeekProgress mProgress;

    public ScheduleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        mView = (RecyclerView)view.findViewById(R.id.schedule);
        mView.setLayoutManager(new LinearLayoutManager(getContext()));
        mProgress = new WeekProgress();
        mDays = mProgress.getDays();
        adapter = new RecyclerAdapter(mDays, ScheduleFragment.this);
        mView.setAdapter(adapter);
        return view;
    }

}
