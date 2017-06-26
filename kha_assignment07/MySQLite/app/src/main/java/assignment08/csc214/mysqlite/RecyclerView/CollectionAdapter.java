package assignment08.csc214.mysqlite.RecyclerView;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import assignment08.csc214.mysqlite.model.Pokemon;
import assignment08.csc214.mysqlite.R;


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
        View view = inflater.inflate(R.layout.collection_view, parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, final int position) {
        holder.bindCollection(mPokemon.get(position), mPokemon);
    }

    @Override
    public int getItemCount() {
        return mPokemon.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUserName;
        List<Pokemon> mUserDatabase;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView)itemView.findViewById(R.id.id_name);
        }

        public void bindCollection(Pokemon pokemon, List<Pokemon> collection) {
            mUserDatabase  = collection;
            tvUserName.setText(pokemon.getName());

        }

    }
}
