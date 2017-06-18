package assignment07.csc214.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import assignment07.csc214.mysqlite.RecyclerView.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.main_recyclerview, fragment)
                .commit();

    }
}
