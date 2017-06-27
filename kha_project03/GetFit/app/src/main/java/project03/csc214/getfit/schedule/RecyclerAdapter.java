package project03.csc214.getfit.schedule;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import project03.csc214.getfit.R;
import project03.csc214.getfit.model.Day;
import project03.csc214.getfit.model.WeekProgress;

/**
 * Created by Tkha on 6/27/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CollectionViewHolder> {

    private List<Day> mDays;
    private Fragment mFragment;

    public RecyclerAdapter(List<Day> days, Fragment fragment) {
        mFragment = fragment;
        mDays = days;
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.schedule_view, parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {
        holder.bindCollection(mDays.get(position), mDays);
    }

    @Override
    public int getItemCount() {
        return mDays.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDay;
        private TextView tvRoutine;
        List<Day> mDays;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            tvDay = (TextView)itemView.findViewById(R.id.day);
            tvRoutine = (TextView)itemView.findViewById(R.id.routine);
        }

        public void bindCollection(Day day, List<Day> collection) {
            mDays  = collection;
            tvDay.setText(day.getDay());
            tvRoutine.setText(day.getRoutine());
        }

    }

}
