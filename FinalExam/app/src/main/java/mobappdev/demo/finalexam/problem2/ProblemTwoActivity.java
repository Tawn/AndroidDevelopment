package mobappdev.demo.finalexam.problem2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mobappdev.demo.finalexam.R;

public class ProblemTwoActivity extends AppCompatActivity {

    private ProblemTwoTopFragment topFragment;
    private ProblemTwoBottomFragment botFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_two);

        // Initialize Fragments
        topFragment = new ProblemTwoTopFragment();
        botFragment = new ProblemTwoBottomFragment();

        // Start manager
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl_top, topFragment)
                .add(R.id.fl_bottom, botFragment)
                .commit();
    }

    public void sendBeloButtonpress(View view) {
        Log.i("test", "sendBeloButtonpress: test");

    }
}
