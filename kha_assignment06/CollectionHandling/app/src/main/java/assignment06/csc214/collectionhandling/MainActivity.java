package assignment06.csc214.collectionhandling;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager)findViewById(R.id.main_layout);
        PokemonListViewFragment fragment = new PokemonListViewFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .add(R.id.main_frame_layout, fragment)
                .commit();

    }
}
