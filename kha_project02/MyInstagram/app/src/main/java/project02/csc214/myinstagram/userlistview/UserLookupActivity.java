package project02.csc214.myinstagram.userlistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import project02.csc214.myinstagram.MainActivity;
import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;

public class UserLookupActivity extends AppCompatActivity {

    private TextView mUsername, mFullname;
    private List<User> mUser;
    private Map<String, User> mUserKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_lookup);

        mUser = UserDatabase.get(getApplicationContext()).getUsers();
        mUserKey = UserDatabase.get(getApplicationContext()).getUserKey();
        String username = getIntent().getStringExtra(MainActivity.USER_KEY);
        User user = mUserKey.get(username);
        String name = user.getFirstname() + " " + user.getLastname();
        mUsername = (TextView)findViewById(R.id.lookup_username);
        mFullname = (TextView)findViewById(R.id.lookup_fullname);

        mFullname.setText(name);
        mUsername.setText(username);

    }

    public void ellipseClick(View view) {
        finish();
    }
}
