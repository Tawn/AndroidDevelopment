package assignment07.csc214.mysqlite.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import assignment07.csc214.mysqlite.R;
import assignment07.csc214.mysqlite.model.FoodStock;

/**
 * Created by Tkha on 6/16/17.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    List<FoodStock> mList;

    public CustomViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView)itemView.findViewById(R.id.food_name);

    }

    public void bindCollection(FoodStock food) {
        tvName.setText(food.getName());

    }

}
