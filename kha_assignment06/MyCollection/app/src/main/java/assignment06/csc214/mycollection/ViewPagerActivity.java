package assignment06.csc214.mycollection;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import assignment06.csc214.mycollection.RecyclerView.RecycleViewCollectionFragment;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        pager = (ViewPager)findViewById(R.id.main_activity_pager);
        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

    }

    public static class CustomAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments;

        public CustomAdapter(FragmentManager manager) {
            super(manager);
            fragments = new ArrayList<>();
            ListViewCollectionFragment fragment1 = new ListViewCollectionFragment();
            RecycleViewCollectionFragment fragment2 = new RecycleViewCollectionFragment();
            fragments.add(fragment1);
            fragments.add(fragment2);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);

        }
    }
}
