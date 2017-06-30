package project03.csc214.getfit.extra;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import project03.csc214.getfit.R;

public class ExtraActivity extends AppCompatActivity {

    public static final String TAG = "ExtraActivity";
    private MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        // Up Navigation
        ActionBar ab  = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // Media Player
        mMediaPlayer = MediaPlayer.create(this, R.raw.im_the_one);

        // Sound Pool
        mSoundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID = mSoundPool.load(getApplicationContext(), R.raw.peter_sound, 1);

    }

    public void cameraButtonPress(View view) {
        Intent intent = new Intent();
    }

    public void soundPoolButtonPress(View view) {
        AudioManager audManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        float maxVolume = (float)audManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float actVolume = (float)audManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float volume = actVolume/maxVolume;
        mSoundPool.play(soundID, volume, volume, 0, 0, 1f);

    }

    public void musicPlayerButtonPress(View view) {
        if (mMediaPlayer.isPlaying()) {
            Log.i(TAG, "soundPoolButtonPress: media stopped");
            mMediaPlayer.pause();
        } else {
            Log.i(TAG, "soundPoolButtonPress: media started");
            mMediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.pause();
    }
}
