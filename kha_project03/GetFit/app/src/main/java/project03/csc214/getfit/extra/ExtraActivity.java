package project03.csc214.getfit.extra;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

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
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        String filename = "ImagePath.jpg";
        File filePath = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File mPhotoFile = new File(filePath, filename);
        Uri uri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".my.package.name.provider", mPhotoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, 1);
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

    public void imgButtonPress(View view) {
        String imgUrl = "http://www.csug.rochester.edu/URWIC/images/rochester.png";
        new AsyncDownload((ImageView) findViewById(R.id.extra_img), getApplicationContext()).execute(imgUrl);
    }
}
