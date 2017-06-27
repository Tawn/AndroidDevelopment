package project03.csc214.getfit.workout;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import project03.csc214.getfit.R;

public class CreateRoutineActivity extends AppCompatActivity {

    public static final String TAG = "Create Routine Activity";
    private CreateRoutineFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routine);

        fragment = new CreateRoutineFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.create_routine_frame, fragment)
                .commit();
    }
}
