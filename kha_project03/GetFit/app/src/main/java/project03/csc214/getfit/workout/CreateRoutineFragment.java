package project03.csc214.getfit.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project03.csc214.getfit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateRoutineFragment extends Fragment {


    public CreateRoutineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_routine, container, false);
    }

}
