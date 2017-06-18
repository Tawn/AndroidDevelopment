package assignment07.csc214.instagram;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import assignment07.csc214.instagram.RecyclerView.RecycleViewCollectionFragment;
import assignment07.csc214.instagram.feed.FeedFragment;
import assignment07.csc214.instagram.profile.ProfileFragment;

/**
 * Created by Tkha on 6/17/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        RecycleViewCollectionFragment mFeedFragment = new RecycleViewCollectionFragment();
        ProfileFragment mProfileFragment = new ProfileFragment();
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
