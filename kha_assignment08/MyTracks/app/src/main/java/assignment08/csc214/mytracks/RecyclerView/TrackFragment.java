package assignment08.csc214.mytracks.RecyclerView;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import assignment08.csc214.mytracks.R;
import assignment08.csc214.mytracks.Radio;
import assignment08.csc214.mytracks.Sounds;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrackFragment extends Fragment {

    public static final String TAG = "TrackFragment";
    private Radio mRadio;

    public interface SoundMessageListener {
        public void soundChange(CharSequence message);
    }

    private SoundMessageListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (SoundMessageListener)context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (SoundMessageListener)activity;
    }

    public TrackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mRadio = new Radio(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track, container, false);

        RecyclerView recycler = (RecyclerView)view.findViewById(R.id.track_recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new TrackAdapter(mRadio.getTracks()));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRadio.release();
    }

    private class TrackHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mSoundName;
        private Sounds mSound;

        public TrackHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.track_view, container, false));

            mSoundName = (TextView)itemView.findViewById(R.id.tv_sound);
            itemView.setOnClickListener(this);
        }

        public void bind(Sounds sound) {
            mSound = sound;
            mSoundName.setText(sound.getSoundName());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "Playing " + mSound.getSoundName() + "!", Toast.LENGTH_SHORT).show();
            mRadio.play(mSound);

            Log.i(TAG, "onClick: Sound message listener invoked");
            mListener.soundChange(mSound.getSoundName());

        }
    }

    private class TrackAdapter extends RecyclerView.Adapter<TrackHolder> {
        private List<Sounds> mTracks;

        public TrackAdapter(List<Sounds> tracks) {
            mTracks = tracks;
        }

        @Override
        public TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new TrackHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(TrackHolder holder, final int position) {
            Log.i(TAG, "onBindViewHolder: Bidning views");
            holder.bind(mTracks.get(position));

        }

        @Override
        public int getItemCount() {
            return mTracks.size();
        }
    }

}
