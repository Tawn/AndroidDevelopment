package assignment07.csc214.instagram.feed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.UUID;

import assignment07.csc214.instagram.PagerActivity;
import assignment07.csc214.instagram.R;
import assignment07.csc214.instagram.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    public static final String ARG_ID = "UserID";
    private List<User> mUserDatabase;

    public FeedFragment() {
        // Required empty public constructor
    }
    public static FeedFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);

        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_feed, container, false);

        return view;
    }

}
