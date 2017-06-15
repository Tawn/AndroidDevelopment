package assignment06.csc214.listhandling.listview;


import android.os.Bundle;
import android.app.ListFragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

import assignment06.csc214.listhandling.R;
import assignment06.csc214.listhandling.model.Collection;
import assignment06.csc214.listhandling.model.Pokemon;

/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonListFragment extends ListFragment {

    private List<Pokemon> mPokemon;

    public PokemonListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.TITLE);
        mPokemon = Collection.get(getActivity()).getCollection();

        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mPokemon
        );
        setListAdapter(adapter);

    }
}
