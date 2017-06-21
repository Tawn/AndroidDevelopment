package assignment08.csc214.mytheme;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import assignment08.csc214.mytheme.ListView.ListViewFragment;
import assignment08.csc214.mytheme.Photo.PhotoActivity;
import assignment08.csc214.mytheme.RecyclerView.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager)findViewById(R.id.pager_main);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);
    }

    public void photoButtonPress(View view) {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }

    public static class PagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentList = new ArrayList<>();
            ListViewFragment lvFragment = new ListViewFragment();
            RecyclerViewFragment rvFragment = new RecyclerViewFragment();
            mFragmentList.add(lvFragment);
            mFragmentList.add(rvFragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
