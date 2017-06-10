package assignment05.csc214.fragmenting;


        import android.content.Context;
        import android.os.Bundle;
        import android.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLifecycleLogger extends Fragment {


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

    // gets the name of current class
    protected final String TAG = getClass().getName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: Called");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Called");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Called");
    }

}

