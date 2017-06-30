package mobappdev.demo.finalexam.problem2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProblemTwoBottomFragment extends FragmentLifecycleLogger {

    private TextView tvReceived;
    private TextConverter convert;


    public interface BotMessageListener {
        public void messageConvert(CharSequence message);
    }

    private BotMessageListener mListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (BotMessageListener) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (BotMessageListener) activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_problem_two_bottom, container, false);
        String key = getArguments().get(ProblemTwoActivity.TOP_MESSAGE_KEY).toString();
        tvReceived = (TextView)view.findViewById(R.id.tv_message);
        tvReceived.setText(key);

        // Initialize converter
        convert = new TextConverter();;

        // Upper Button Press
        Button bUpper = (Button)view.findViewById(R.id.b_upper);
        Button bLower = (Button)view.findViewById(R.id.b_lower);

        bUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = convert.toUpper(tvReceived.getText().toString());
                mListener.messageConvert(message);
            }
        });

        bLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = convert.toLower(tvReceived.getText().toString());
                mListener.messageConvert(message);            }
        });

        return view;
    }

}
