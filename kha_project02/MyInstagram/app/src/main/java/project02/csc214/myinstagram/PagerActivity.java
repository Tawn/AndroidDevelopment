package project02.csc214.myinstagram;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import project02.csc214.myinstagram.RecyclerView.RecycleViewCollectionFragment;
import project02.csc214.myinstagram.login.LoginActivity;
import project02.csc214.myinstagram.profile.ProfileFragment;
import project02.csc214.myinstagram.profile.RecyclerViewProfileFragment;

public class PagerActivity extends AppCompatActivity {

    public static String TAG = "PagerActivity";
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        Log.i(TAG, "onCreate: Create");

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        pager = (ViewPager)findViewById(R.id.main_activity_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public static final String TAG = "PageerAdapter";
        private List<Fragment> mFragments;
        private RecycleViewCollectionFragment mFeedFragment;
        private RecyclerViewProfileFragment mProfileFragment;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            Log.i(TAG, "PagerAdapter: Constructor invoked");
            mFragments = new ArrayList<>();
            mFeedFragment = new RecycleViewCollectionFragment();
            mProfileFragment = new RecyclerViewProfileFragment();
            mFragments.add(mFeedFragment);
            mFragments.add(mProfileFragment);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
