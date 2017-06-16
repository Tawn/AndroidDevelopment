package assignment06.csc214.mycollection.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import assignment06.csc214.mycollection.R;
import assignment06.csc214.mycollection.model.Pokemon;

/**
 * Created by Tkha on 6/16/17.
 */

public class CollectionViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvType;
    private TextView tvHP;

    public CollectionViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView)itemView.findViewById(R.id.item_name);
        tvType = (TextView)itemView.findViewById(R.id.item_type);
        tvHP = (TextView)itemView.findViewById(R.id.item_hp);
    }

    public void bindCollection(Pokemon pokemon) {
        tvName.setText(pokemon.getName());
        tvType.setText(pokemon.getmType());
        tvHP.setText(pokemon.getmHitPoints() + " HP");
    }


}
