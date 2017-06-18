package project02.csc214.myinstagram;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import project02.csc214.myinstagram.RecyclerView.RecycleViewCollectionFragment;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.login.LoginActivity;
import project02.csc214.myinstagram.model.User;
import project02.csc214.myinstagram.profile.ProfileFragment;
import project02.csc214.myinstagram.profile.RecyclerViewProfileFragment;

import static android.provider.CalendarContract.CalendarCache.URI;

public class PagerActivity extends AppCompatActivity {

    public static String TAG = "PagerActivity";
    private ViewPager pager;
    private List<User> mUsers;
    private User mCurrentUser;
    private Map<String, User> mUserKey;
    private final int CAMERA_REQUEST = 1;
    public static SQLiteOpenHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        mUsers = UserDatabase.get(getApplicationContext()).getUsers();

        // Camerea Setup
        sqlHelper = new SQLiteOpenHelper(this, "UserIMG.sqlite, null, 1");
        // User Data Setup
        mUsers = UserDatabase.get(getApplicationContext()).getUsers();
        mUserKey = UserDatabase.get(getApplicationContext()).getUserKey();
        String user = getIntent().getStringExtra(MainActivity.USER_KEY);
        mCurrentUser = mUserKey.get(user);

        // ViewPager Setup
        pager = (ViewPager)findViewById(R.id.main_activity_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);

    }

    public void saveImage(View view) {
        try {
            FileInputStream fis = new FileInputStream("/storage/sdcard/" + mCurrentUser.getUsername() + ".jpg");
            byte[] image = new byte[fis.available()];
            fis.read(image);
            ContentValues values = new ContentValues();
            values.put("a", image);
            db.insert("image_table", null, values);
            fis.close();
        } catch (IOException e){
            e.printStackTrace();
        }
            }
    public void getImage(View view) {
        Cursor c = db.rawQuery("select * from image_table", null);
        if(c.moveToNext()) {
            byte[] image = c.getBlob(0);
            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
            ImageView profilePic = (ImageView)findViewById(R.id.profile_pic);
            profilePic.setImageBitmap(bmp);
        }
    }


    public void cameraButtonPress(View view) {
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File("sdcard/camera_app");
        if(!file.exists()) {
            file.mkdir();
        }
        File image_file = new File(file, "cam_image");
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, image_file);
        startActivityForResult(camera_intent, CAMERA_REQUEST);

    }


    public class PagerAdapter extends FragmentPagerAdapter {

        public static final String TAG = "PageerAdapter";
        private List<Fragment> mFragments;
        private RecycleViewCollectionFragment mFeedFragment;
        private RecyclerViewProfileFragment mProfileFragment;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            Log.i(TAG, "PagerAdapter: Constructor invoked");
            mFragments = new ArrayList<>();
            mFeedFragment = new RecycleViewCollectionFragment();
            mProfileFragment = new RecyclerViewProfileFragment();
            mFragments.add(mFeedFragment);
            mFragments.add(mProfileFragment);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
