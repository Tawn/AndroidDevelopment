package assignment06.csc214.mycollection.RecyclerView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.UUID;

import assignment06.csc214.mycollection.R;
import assignment06.csc214.mycollection.ViewPagerActivity;
import assignment06.csc214.mycollection.model.Collection;
import assignment06.csc214.mycollection.model.Pokemon;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewCollectionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Pokemon> mPokemonColleciton;
    public static final String ARG_ID = "Pokemon ID";

    public RecycleViewCollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(ViewPagerActivity.TAG, "onCreateView: ReyclerView fragment created");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycle_view_collection, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.collection_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CollectionAdapter adapter = new CollectionAdapter(Collection.get(getActivity())
                .getCollection(), RecycleViewCollectionFragment.this);
        mPokemonColleciton = Collection.get(getActivity()).getCollection();
        mRecyclerView.setAdapter(adapter);
        return view;
    }

}
