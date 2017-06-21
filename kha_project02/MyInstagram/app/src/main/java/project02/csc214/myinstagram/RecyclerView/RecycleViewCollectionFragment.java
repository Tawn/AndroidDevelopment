package project02.csc214.myinstagram.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import project02.csc214.myinstagram.MainActivity;
import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewCollectionFragment extends Fragment {

    private static final String TAG = "RecyclerFragment";
    private RecyclerView mRecyclerView;
    private List<User> mUsers;
    public static final String ARG_ID = "Pokemon ID";

    public RecycleViewCollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.feed_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Map<String, User> mUserKey = UserDatabase.get(getContext()).getUserKey();
        User mCurrentUser = mUserKey.get(MainActivity.CURRENT_USER);
        Log.i(TAG, "onCreateView: created " + mCurrentUser.getFirstname());


        mUsers = UserDatabase.get(getContext()).getUsers();

        // Recycler View of All Users in Database
        CollectionAdapter adapter = new CollectionAdapter(
                mUsers,
                RecycleViewCollectionFragment.this);

        // Attach adapter
        mRecyclerView.setAdapter(adapter);

        // Return View
        return view;
    }

}