package assignment08.csc214.mytracks;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tkha on 6/24/17.
 */

public class Radio {

    private static final String SOUND_PATH = "tracks";

    private AssetManager mAssets;
    private List<Sounds> mTracks;
    private SoundPool mSoundPool;


    public Radio(Context context) {
        mAssets = context.getAssets();
        mTracks = new ArrayList<>();
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        String[] trackNames;
        try {
            trackNames = mAssets.list(SOUND_PATH);
            int i = 1;
            for(String filename : trackNames) {
                String path = SOUND_PATH + "/" + filename;
                Sounds sounds = new Sounds(path, "Sounds " + i);
                mTracks.add(sounds);

            try {
                AssetFileDescriptor afd = mAssets.openFd(sounds.getPath());
                int soundId = mSoundPool.load(afd, 1);
                sounds.setId(soundId);
            }
            catch(IOException ioe) {
            }
            i = i + 1;
            }
        } catch(IOException ioe) {
        }
    }

    public void play(Sounds track) {
        Integer id = track.getId();
        if(id != null) {
            mSoundPool.play(
                    id,   // sound id
                    1.0f, // left volume
                    1.0f, // right volume
                    1,    // priority (ignored)
                    0,    // loop counter, 0 for no loop
                    1.0f  // playback rate
            );
        }
    }

    public List<Sounds> getTracks() {
        return mTracks;
    }

    public void release() {
        mSoundPool.release();
    }

}
