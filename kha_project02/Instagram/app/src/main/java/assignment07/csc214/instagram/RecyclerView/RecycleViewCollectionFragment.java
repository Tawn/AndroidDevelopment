package assignment07.csc214.instagram.RecyclerView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import assignment07.csc214.instagram.model.User;
import assignment07.csc214.instagram.R;
import assignment07.csc214.instagram.model.UserDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewCollectionFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private List<User> mUserDatabase;
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

        CollectionAdapter adapter = new CollectionAdapter(UserDatabase.get(getActivity()).getCollection(), RecycleViewCollectionFragment.this);
        mUserDatabase = UserDatabase.get(getActivity()).getCollection();
        mRecyclerView.setAdapter(adapter);
        return view;
    }

}
