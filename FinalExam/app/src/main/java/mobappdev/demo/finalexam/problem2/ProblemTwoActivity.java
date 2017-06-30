package mobappdev.demo.finalexam.problem2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mobappdev.demo.finalexam.R;

public class ProblemTwoActivity extends AppCompatActivity implements ProblemTwoTopFragment.TopMessageListener, ProblemTwoBottomFragment.BotMessageListener {

    public static final String TAG = "P2Activity";
    public static final String TOP_MESSAGE_KEY = "message_to_bot";
    public static final String BOT_MESSAGE_KEY = "convert_top_message";


    private ProblemTwoTopFragment topFragment;
    private ProblemTwoBottomFragment botFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_two);

        // Initialize Fragments
        topFragment = new ProblemTwoTopFragment();
        botFragment = new ProblemTwoBottomFragment();

        // Bundle at initial
        Bundle bundle = new Bundle();
        bundle.putString(BOT_MESSAGE_KEY, "first");
        topFragment = new ProblemTwoTopFragment();
        topFragment.setArguments(bundle);

        // Start manager
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl_top, topFragment)
                .commit();
    }

    @Override
    public void messageSentDown(CharSequence message) {
        Log.i(TAG, "messageSentDown: " + message);

        // Add arguments to bottom fragment
        Bundle bundle = new Bundle();
        bundle.putString(TOP_MESSAGE_KEY, message.toString());
        botFragment = new ProblemTwoBottomFragment();
        botFragment.setArguments(bundle);

        // Inflate bottom fragment
        manager.beginTransaction()
                .add(R.id.fl_bottom, botFragment)
                .commit();

    }

    @Override
    public void messageConvert(CharSequence message) {
        Log.i(TAG, "messageConvert: " + message);

        // Add arguments to top fragment
        Bundle bundle = new Bundle();
        bundle.putString(BOT_MESSAGE_KEY, message.toString());
        topFragment = new ProblemTwoTopFragment();
        topFragment.setArguments(bundle);

        // Inflate top fragment
        manager.beginTransaction()
                .add(R.id.fl_top, topFragment)
                .commit();

    }
}
