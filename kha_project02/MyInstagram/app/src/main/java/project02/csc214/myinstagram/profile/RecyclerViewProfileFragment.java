package project02.csc214.myinstagram.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.RecyclerView.CollectionAdapter;
import project02.csc214.myinstagram.RecyclerView.RecycleViewCollectionFragment;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;

/**
 * Created by Tkha on 6/18/17.
 */

public class RecyclerViewProfileFragment extends Fragment {

    private static final String TAG = "RecyclerFragment";
    private RecyclerView mRecyclerView;
    private List<User> mUsers;
    public static final String ARG_ID = "Pokemon ID";

    public RecyclerViewProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: created");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.profile_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mUsers = UserDatabase.get(getContext()).getUsers();

        // Recycler View of All Users in Database
        CollectionAdapter adapter = new CollectionAdapter(
                mUsers,
                RecyclerViewProfileFragment.this);

        // Attach adapter
        mRecyclerView.setAdapter(adapter);

        // Return View
        return view;
    }
}