package assignment06.csc214.mycollection.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import assignment06.csc214.mycollection.model.Pokemon;
import assignment06.csc214.mycollection.R;

/**
 * Created by Tkha on 6/16/17.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionViewHolder> {
    private List<Pokemon> mPokemon;
    public CollectionAdapter(List<Pokemon> pokemon) {
        mPokemon = pokemon;
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_pokemon, parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {
        holder.bindCollection(mPokemon.get(position));
    }

    @Override
    public int getItemCount() {
        return mPokemon.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private TextView tvType;
        private TextView tvHP;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = (TextView)itemView.findViewById(R.id.item_name);
            tvType = (TextView)itemView.findViewById(R.id.item_type);
            tvHP = (TextView)itemView.findViewById(R.id.item_hp);
        }

        public void bindCollection(Pokemon pokemon) {
            tvName.setText(pokemon.getName());
            tvType.setText(pokemon.getmType());
            tvHP.setText(pokemon.getmHitPoints() + " HP");
        }


        @Override
        public void onClick(View v) {

        }
    }
}
