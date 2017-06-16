package assignment06.csc214.collections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.UUID;

import assignment06.csc214.collections.model.Collection;
import assignment06.csc214.collections.model.Pokemon;


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

    public static RecycleViewCollectionFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);

        RecycleViewCollectionFragment fragment = new RecycleViewCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycle_view_collection, container, false);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.collection_recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        mPokemonColleciton = Collection.get(getActivity()).getCollection();
//        // Set Adapter
//        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<Pokemon>(
//                getActivity(),
//                android.R.layout.simple_list_item_1,
//                mPokemonColleciton
//        );
//        lvList.setAdapter(adapter);
//
//        // onItemClick Listener
//        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                DialogListViewFragment dialog = new DialogListViewFragment()
//                        .newInstance(mPokemonColleciton.get(position));
//                dialog.setTargetFragment(RecycleViewCollectionFragment.this, 2);
//                dialog.show(getFragmentManager(), "Test");
//
//            }
//        });
//        getActivity().setTitle(getString(R.string.catchem));
        return view;
    }

}
