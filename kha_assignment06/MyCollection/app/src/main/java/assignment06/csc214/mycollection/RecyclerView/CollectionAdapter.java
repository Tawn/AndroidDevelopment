package assignment06.csc214.mycollection.RecyclerView;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import assignment06.csc214.mycollection.DialogListViewFragment;
import assignment06.csc214.mycollection.ListViewCollectionFragment;
import assignment06.csc214.mycollection.model.Collection;
import assignment06.csc214.mycollection.model.Pokemon;
import assignment06.csc214.mycollection.R;

/**
 * Created by Tkha on 6/16/17.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {
    private List<Pokemon> mPokemon;
    private Fragment fragment;

    public CollectionAdapter(List<Pokemon> pokemon, Fragment frag) {
        mPokemon = pokemon;
        fragment = frag;

    }
    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_pokemon, parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("hehe", "onClick: " + mPokemon.get(position).getName());
                DialogListViewFragment dialog = new DialogListViewFragment()
                        .newInstance(mPokemon.get(position));
                dialog.setTargetFragment(fragment, 2);
                dialog.show(fragment.getFragmentManager(), "Test");
            }
        });
        holder.bindCollection(mPokemon.get(position), mPokemon);
    }

    @Override
    public int getItemCount() {
        return mPokemon.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvType;
        private TextView tvHP;
        List<Pokemon> mPokemonColleciton;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.item_name);
            tvType = (TextView)itemView.findViewById(R.id.item_type);
            tvHP = (TextView)itemView.findViewById(R.id.item_hp);
        }

        public void bindCollection(Pokemon pokemon, List<Pokemon> collection) {
            mPokemonColleciton  = collection;
            tvName.setText(pokemon.getName());
            tvType.setText(pokemon.getmType());
            tvHP.setText(pokemon.getmHitPoints() + " HP");
        }

    }
}
