package project03.csc214.getfit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tvDay;

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
        setDay();
        return view;
    }

    public void setDay() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        switch(day) {
            case 1: tvDay.setText("Sunday");
                break;
            case 2: tvDay.setText("Monday");
                break;
            case 3: tvDay.setText("Tuesday");
                break;
            case 4: tvDay.setText("Wednesday");
                break;
            case 5: tvDay.setText("Thursday");
                break;
            case 6: tvDay.setText("Friday");
                break;
            case 7: tvDay.setText("Saturday");
                break;
        }
    }

}
