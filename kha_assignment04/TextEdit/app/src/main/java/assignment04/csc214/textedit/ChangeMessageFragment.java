package assignment04.csc214.textedit;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ChangeMessageFragment extends Fragment {


    public interface MessageChangeListener {
        public void messageChanged(CharSequence message);
        public void messageCanceled();
    }

    private MessageChangeListener mMessageChangeListener;

    public ChangeMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMessageChangeListener = (MessageChangeListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mMessageChangeListener = (MessageChangeListener)activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_message, container, false);
        final EditText editTextMessage = (EditText)view.findViewById(R.id.edit_text);
        editTextMessage.setText(getArguments().getString(MainActivity.SAVED_MESSAGE));
        Button okButton = (Button)view.findViewById(R.id.set_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageChangeListener.messageChanged(editTextMessage.getText());
            }
        });

        Button cancelButton = (Button)view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageChangeListener.messageCanceled();
            }
        });

        return view;
    }

    // Log Indicator
    @Override
    public void onStart() {
        super.onStart();
        Log.d(MainActivity.TAG, "Fragment Activity Started");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(MainActivity.TAG, "Fragment Activity Resumed");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(MainActivity.TAG, "Fragment Activity Paused");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(MainActivity.TAG, "Fragment Activity Stopped");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG, "Fragment Activity Destroyed");

    }

}
