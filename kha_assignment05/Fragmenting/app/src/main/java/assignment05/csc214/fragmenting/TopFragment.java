package assignment05.csc214.fragmenting;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends FragmentLifecycleLogger {

    private EditText mTopInput;

    public interface TopMessageListener {
        public void messageSentDown(CharSequence message);
    }

    private TopMessageListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (TopMessageListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (TopMessageListener)activity;
    }

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        Log.d(TAG, "onCreateView: Created New Fragment");
        TextView mTopDisplay = (TextView)view.findViewById(R.id.top_display);
        mTopDisplay.setText(getArguments().getString(MainActivity.INPUT_KEY));

        mTopInput = (EditText)view.findViewById(R.id.text_send_back);
        Button mSendBack = (Button)view.findViewById(R.id.send_back);
        mSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.messageSentDown(mTopInput.getText().toString());
            }
        });

        return view;
    }



}
