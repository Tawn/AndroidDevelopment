package project02.csc214.myinstagram.RecyclerView;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.model.User;

/**
 * Created by Tkha on 6/16/17.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder> {
    private List<User> mUser;
    private Fragment fragment;

    public CollectionAdapter(List<User> user, Fragment frag) {
        mUser = user;
        fragment = frag;

    }
    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_feed, parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, final int position) {
        holder.bindCollection(mUser.get(position), mUser);
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public static class CollectionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUserName;
        List<User> mUserDatabase;

        public CollectionViewHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView)itemView.findViewById(R.id.tv_username);
        }

        public void bindCollection(User user, List<User> collection) {
            mUserDatabase  = collection;
            tvUserName.setText(user.getUsername());

        }

    }
}
