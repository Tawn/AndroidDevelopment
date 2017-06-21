package assignment08.csc214.mytheme.RecyclerView;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import assignment08.csc214.mytheme.Collection.Person;
import assignment08.csc214.mytheme.R;

/**
 * Created by Tkha on 6/20/17.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {

    private List<Person> mList;
    private Fragment mFragment;

    public CollectionAdapter(List<Person> list, Fragment fragment) {
        Log.i("Adapter Create", "Constructor:  " + " list" + list.size());
        mList = list;
        mFragment = fragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("Adapter Create", "onCreateView:  ViewHolder" + mList.size());
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindCollection(mList.get(position), mList);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Set the values of each individual item

        private TextView tvName;

        List<Person> mList;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.id_item_name);

        }

        public void bindCollection(Person person, List<Person> list) {
            Log.i("BindColl", "onCreateView:  list " + list.size());
            mList = list;
            tvName.setText(person.getName());
        }
    }

}