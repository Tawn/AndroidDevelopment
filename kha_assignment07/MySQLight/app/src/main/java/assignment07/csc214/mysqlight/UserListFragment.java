package assignment07.csc214.mysqlight;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import assignment07.csc214.mysqlight.model.User;
import assignment07.csc214.mysqlight.model.UserDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private UserDatabase mUserCollection;
    private RecyclerView mRecyclerView;
    private UserAdapter mAdapter;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    private class UserAdapter extends RecyclerView.Adapter<MovieViewHolder> {
        private static final String TAG = "MovieAdapter";
        private List<User> mUser;

        public UserAdapter(List<User> user) {
            mUser = user;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.view_movie, parent, false);
            return new MovieViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder(holder," + position +") called");
            User user = mMovies.get(position);
            holder.bind(movie);
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "getItemCount() returning " + mMovies.size());
            return mMovies.size();
        }

        /**
         * This method is called whenever the set of movies changes.  This could mean that a movie
         * was added, removed, or updated.
         *
         * @param movies The current set of movies.
         */
        public void setMovies(List<User> list) {
            mUser = user;
            notifyDataSetChanged();
        }
    }

    private class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mTitle;
        private final TextView mDirector;
        private final TextView mGenre;
        private final TextView mReleaseYear;
        private final Calendar mCalendar;
        private Movie mMovie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView)itemView.findViewById(R.id.text_view_title);
            mDirector = (TextView)itemView.findViewById(R.id.text_view_director);
            mGenre = (TextView)itemView.findViewById(R.id.text_view_genre);
            mReleaseYear = (TextView)itemView.findViewById(R.id.text_view_release_year);
            mCalendar = Calendar.getInstance();
            itemView.setOnClickListener(this);
        }

        public void bind(Movie movie) {
            mMovie = movie;
            mTitle.setText(movie.getTitle());
            mDirector.setText(movie.getDirector());
            mGenre.setText(movie.getGenre());
            mCalendar.setTime(movie.getReleaseDate());
            mReleaseYear.setText(Integer.toString(mCalendar.get(Calendar.YEAR)));
        }

        @Override
        public void onClick(View v) {
            Intent intent = MovieActivity.newIntent(getContext(), mMovie.getId());
            getContext().startActivity(intent);
        }
    }

}
