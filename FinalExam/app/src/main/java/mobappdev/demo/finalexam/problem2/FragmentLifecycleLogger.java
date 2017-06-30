package mobappdev.demo.finalexam.problem2;


import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLifecycleLogger extends Fragment {

    // gets the name of current class
    protected final String TAG = getClass().getName();

    public FragmentLifecycleLogger() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: Called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: Called");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Called");
    }

}

