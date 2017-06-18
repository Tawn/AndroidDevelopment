package assignment07.csc214.instagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import assignment07.csc214.instagram.login.LoginActivity;

public class PagerActivity extends AppCompatActivity {

    public static String TAG = "PagerActivity";
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        Log.i(TAG, "onCreate: Create");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        pager = (ViewPager)findViewById(R.id.main_activity_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);
    }

    public void profileButtonPress(View view) {
        Log.i(TAG, "profileButtonPress: Pressed");
    }

    public void cameraButtonPress(View view) {
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camera_intent);
        startActivityForResult(camera_intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_CANCELED) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView feedImage = (ImageView) findViewById(R.id.feed_image);
            feedImage.setImageBitmap(photo);
        }
    }
}
