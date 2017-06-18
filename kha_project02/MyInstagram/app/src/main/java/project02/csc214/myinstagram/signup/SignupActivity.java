package project02.csc214.myinstagram.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import project02.csc214.myinstagram.MainActivity;
import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";
    private List<User> mUserDatabase;
    private List<String> mUsernames;
    private EditText mUsername,mPassword, mFirstName, mLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load Database
        mUserDatabase = UserDatabase.get(getApplicationContext()).getUsers();
        mUsernames = UserDatabase.get(getApplicationContext()).getUsernames();
        // Hide Toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        // Start Login
        SignupFragment fragment = new SignupFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.activity_signup_framelayout, fragment)
                .commit();

    }

    public void signupButtonPress(View view) {
        Log.i(TAG, "signupButtonPress: Creating new user into database.");
        // Database
        mUsername = (EditText)findViewById(R.id.et_signup_username);
        mPassword = (EditText)findViewById(R.id.et_signup_password);
        mFirstName = (EditText)findViewById(R.id.et_signup_first_name);
        mLastName = (EditText)findViewById(R.id.et_signup_last_name);
        if(mUsernames.contains(mUsername.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Username already exists.", Toast.LENGTH_SHORT).show();

        } else if (mUsername.getText().toString().length() < 4
                || mPassword.getText().toString().length() < 4
                ||  mFirstName.getText().toString().length() < 4
                || mLastName.getText().toString().length() < 4) {
            Toast.makeText(getApplicationContext(), "Each fields must be greater than 3 characters"
                    , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            User user = new User();
            user.setUsername(mUsername.getText().toString());
            user.setFirstname(mFirstName.getText().toString());
            user.setLastname(mLastName.getText().toString());
            user.setPassword(mPassword.getText().toString());
            UserDatabase.get(getApplicationContext()).addUser(user);
            Intent intent = new Intent();
            intent.putExtra(MainActivity.USER_KEY, user.getUsername());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }

    public void signInButtonPress(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
