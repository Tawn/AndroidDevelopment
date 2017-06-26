package assignment07.csc214.mysqlites.RecyclerView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import assignment07.csc214.mysqlites.R;
import assignment07.csc214.mysqlites.database.PokemonDatabase;
import assignment07.csc214.mysqlites.model.Pokemon;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionRecyclerView extends Fragment {


    private static final String TAG = "RecyclerFragment";
    private RecyclerView mRecyclerView;
    private List<Pokemon> mPokemons;
    public static final String ARG_ID = "Pokemon ID";

    public CollectionRecyclerView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection_recycler_view, container, false);
        RecyclerView mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        // Recycler View of All Users in Database
        mPokemons = PokemonDatabase.get(getContext()).getUsers();
        CollectionAdapter adapter = new CollectionAdapter(
                mPokemons,
                CollectionRecyclerView.this);

        // Attach adapter
        mRecyclerView.setAdapter(adapter);

        // Return View
        return view;
    }

}
