package project02.csc214.myinstagram;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project02.csc214.myinstagram.RecyclerView.RecycleViewCollectionFragment;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;
import project02.csc214.myinstagram.profile.ProfileFragment;
import project02.csc214.myinstagram.userlistview.UserListView;


public class PagerActivity extends AppCompatActivity {

    public static String TAG = "PagerActivity";
    private ViewPager pager;
    private List<User> mUsers;
    private User mCurrentUser;
    private Map<String, User> mUserKey;
    private final int CAMERA_REQUEST = 1;
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        mUsers = UserDatabase.get(getApplicationContext()).getUsers();



        // User Data Setup
        mUsers = UserDatabase.get(getApplicationContext()).getUsers();
        mUserKey = UserDatabase.get(getApplicationContext()).getUserKey();
        user = getIntent().getStringExtra(MainActivity.USER_KEY);
        mCurrentUser = mUserKey.get(user);

        Log.i(TAG, "onCreate: photopath: " + mCurrentUser.getPhotoPath());

        // ViewPager Setup
        pager = (ViewPager)findViewById(R.id.main_activity_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setCurrentItem(1);

    }

    public void setProfilePic() {
        if(mCurrentUser.getPhotoPath() != "abc") {
            try {
                File file = new File(mCurrentUser.getPhotoPath(), mCurrentUser.getUsername() + "profile.jpg");
                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(file));
                ImageView img=(ImageView)findViewById(R.id.profile_pic);
                img.setImageBitmap(b);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void cameraButtonPress(View view) {
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        ImageView profile_pic = (ImageView)findViewById(R.id.profile_pic);
        String directory = saveToInternalStorage(bitmap);
        loadImageFromStorage(directory);
        mCurrentUser.setPhotoPath(directory);
        UserDatabase.get(getApplicationContext()).updateUser(mCurrentUser);

    }

    // Bobby said it's okay to copy methods (this is the only one I copied) - and obvious not a portion
    // of a project.
    // Source: https://stackoverflow.com/questions/17674634/saving-and-reading-bitmaps-images-from-internal-memory-in-android
    // This method is to store image into an internal source folder
    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory, mCurrentUser.getUsername() + "profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    private void loadImageFromStorage(String path)
    {

        try {
            File file = new File(path, mCurrentUser.getUsername() + "profile.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            ImageView imgage = (ImageView)findViewById(R.id.profile_pic);
            ImageView imgage2 = (ImageView)findViewById(R.id.feed_image);
            imgage.setImageBitmap(bitmap);
            imgage2.setImageBitmap(bitmap);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public void userSearchButtonpress(View view) {
    }

    public void ellipseClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }


    public class PagerAdapter extends FragmentPagerAdapter {

        public static final String TAG = "PageerAdapter";
        private List<Fragment> mFragments;
        private RecycleViewCollectionFragment mFeedFragment;
        private ProfileFragment mProfileFragment;
        private UserListView mUserList;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            Log.i(TAG, "PagerAdapter: Constructor invoked");
            mFragments = new ArrayList<>();
            mUserList = new UserListView();
            mFeedFragment = new RecycleViewCollectionFragment();
            mProfileFragment = new ProfileFragment();
            mFragments.add(mUserList);
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
