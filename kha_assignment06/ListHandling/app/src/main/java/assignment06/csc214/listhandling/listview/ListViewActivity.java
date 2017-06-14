package assignment06.csc214.listhandling.listview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import assignment06.csc214.listhandling.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fl_list_view);
        if(fragment == null) {
            fragment = new PokemonListFragment();
            manager.beginTransaction()
                    .add(R.id.fl_list_view, fragment)
                    .commit();
        }

    }
}
