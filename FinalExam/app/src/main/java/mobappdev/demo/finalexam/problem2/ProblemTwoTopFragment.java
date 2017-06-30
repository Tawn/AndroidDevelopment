package mobappdev.demo.finalexam.problem2;


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


import mobappdev.demo.finalexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProblemTwoTopFragment extends FragmentLifecycleLogger {

    public static final String TAG = "P2TopFragment";
    private TextView tvResponse;


    public interface TopMessageListener {
        public void messageSentDown(CharSequence message);
    }

    private TopMessageListener mListener;


    public ProblemTwoTopFragment() {
        // Required empty public constructor
    }

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_problem_two_top, container, false);
        final EditText tvTextToBelow = (EditText)view.findViewById(R.id.et_input);
        Button bSendBelow = (Button)view.findViewById(R.id.b_send_below);

        // Set Argument
        String key = getArguments().get(ProblemTwoActivity.BOT_MESSAGE_KEY).toString();
        Log.i(TAG, "onCreateView: Key:" + key);
        tvResponse = (TextView)view.findViewById(R.id.tv_response);
        if(key != "first") {
            tvResponse.setText(key);
        }

        // add Listener
        bSendBelow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.messageSentDown(tvTextToBelow.getText());
            }
        });

        return view;
    }

}
