package assignment06.csc214.collectionhandling;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

import assignment06.csc214.collectionhandling.model.Collection;
import assignment06.csc214.collectionhandling.model.Pokemon;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonListViewFragment extends Fragment {

    private List<Pokemon> mPokemonColleciton;
    public static final String ARG_ID = "Pokemon ID";

    public PokemonListViewFragment() {
        // Required empty public constructor
    }

    public static PokemonListViewFragment newInstance(UUID id) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);

        PokemonListViewFragment fragment = new PokemonListViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pokemon_list_view, container, false);
        ListView lvList = (ListView)view.findViewById(R.id.collection_list_view);
        mPokemonColleciton = Collection.get(getActivity()).getCollection();
        // Set Adapter
        ArrayAdapter <Pokemon> adapter = new ArrayAdapter<Pokemon>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mPokemonColleciton
        );
        lvList.setAdapter(adapter);

        // onItemClick Listener
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager manager = getFragmentManager();
                DialogListViewFragment dialog = new DialogListViewFragment()
                        .newInstance(mPokemonColleciton.get(position));
                dialog.setTargetFragment(PokemonListViewFragment.this, 2);
                dialog.show(manager, "Test");
            }
        });
        getActivity().setTitle(getString(R.string.catchem));
        return view;
    }

}
