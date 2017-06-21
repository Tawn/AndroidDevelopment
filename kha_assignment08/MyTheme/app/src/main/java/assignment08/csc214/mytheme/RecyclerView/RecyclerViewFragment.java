package assignment08.csc214.mytheme.RecyclerView;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import assignment08.csc214.mytheme.Collection.Person;
import assignment08.csc214.mytheme.Collection.PersonCollection;
import assignment08.csc214.mytheme.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Person> mList;
    private CollectionAdapter adapter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = PersonCollection.get(getActivity()).getList();
        adapter = new CollectionAdapter(mList, RecyclerViewFragment.this);
        Log.i("RCFragment", "onCreateView: " + mList.size());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        Log.i("RecyclerVIew", "onCreateView: ");

        //------------------------  INITIALIZE AND CREATE LAYOUT  -----------------------//
        mList = PersonCollection.get(getActivity()).getList();
        adapter = new CollectionAdapter(mList, RecyclerViewFragment.this);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
        //-------------------------------------------------------------------------------//
        return view;
    }

}
