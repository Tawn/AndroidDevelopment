package assignment05.csc214.fragmenting;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends FragmentLifecycleLogger {

    private TextView mMessageDisplay;


    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Called");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);

        // Setting bottom text
        mMessageDisplay = (TextView)view.findViewById(R.id.bottom_message);
        messageSentBack(view, getArguments().getString(MainActivity.INPUT_KEY));

        // Return fragment
        return view;
    }

    // Set tag
    public void messageSentBack(View view, CharSequence message) {
        mMessageDisplay = (TextView)view.findViewById(R.id.bottom_message);
        mMessageDisplay.setText(message);
    }

}
