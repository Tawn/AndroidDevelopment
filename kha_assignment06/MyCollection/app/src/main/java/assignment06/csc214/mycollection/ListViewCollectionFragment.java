package assignment06.csc214.mycollection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.UUID;

import assignment06.csc214.mycollection.model.Collection;
import assignment06.csc214.mycollection.model.Pokemon;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewCollectionFragment extends Fragment {

    private List<Pokemon> mPokemonColleciton;
    public static final String ARG_ID = "Pokemon ID";

    public ListViewCollectionFragment() {
        // Required empty public constructor
    }

    public static ListViewCollectionFragment newInstance(UUID id) {
        Log.d(ViewPagerActivity.TAG, "newInstance: ListView Fragment instance invoked");
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);

        ListViewCollectionFragment fragment = new ListViewCollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(ViewPagerActivity.TAG, "onCreateView: ListView Fragment Created");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_view_collection, container, false);
        ListView lvList = (ListView) view.findViewById(R.id.collection_list_view);
        mPokemonColleciton = Collection.get(getActivity()).getCollection();
        // Set Adapter
        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<Pokemon>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mPokemonColleciton
        );
        lvList.setAdapter(adapter);

        // onItemClick Listener
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogListViewFragment dialog = new DialogListViewFragment()
                        .newInstance(mPokemonColleciton.get(position));
                        dialog.setTargetFragment(ListViewCollectionFragment.this, 2);
                        dialog.show(getFragmentManager(), "Test");


            }
        });
        getActivity().setTitle(R.string.catchem);
        return view;
    }

}
