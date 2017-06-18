package assignment07.csc214.mysqlite.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import assignment07.csc214.mysqlite.R;
import assignment07.csc214.mysqlite.model.FoodStock;

/**
 * Created by Tkha on 6/16/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private static final String TAG = "CustomAdapter";
    private List<FoodStock> mList;

    public CustomAdapter(List<FoodStock> list) {
        mList = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: Layout Inflated");
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.view_foodstock, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
