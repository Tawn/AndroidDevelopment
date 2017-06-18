package project02.csc214.myinstagram.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import project02.csc214.myinstagram.R;
import project02.csc214.myinstagram.database.UserDatabase;
import project02.csc214.myinstagram.model.User;
import project02.csc214.myinstagram.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private List<User> mUserDatabase;
    private Map<String, String> mUserMap;
    private EditText mUsername,mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get datamap
        mUserDatabase = UserDatabase.get(getApplicationContext()).getUsers();
        mUserMap = UserDatabase.get(getApplicationContext()).getUserMap();

        // Hide Toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        // Start Login
        LoginFragment fragment = new LoginFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.activity_login_framelayout, fragment)
                .commit();

    }

    // Return to Main Activity
    public void loginButtonPress(View view) {
        mUsername = (EditText)findViewById(R.id.et_username);
        mPassword = (EditText)findViewById(R.id.et_password);
        Log.i(TAG, "onClick: Login button pressed\nUser:" +
                mUsername.getText() + "\nPassword: " +
                mPassword.getText());
        String user = mUsername.getText().toString();
        String pass = mPassword.getText().toString();

        if(mUserMap.containsKey(user) && mUserMap.get(user).equals(pass)) {
            Toast.makeText(getApplicationContext(), "Login successful."
                    , Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid Input. Please try again."
                    , Toast.LENGTH_SHORT).show();
        }
    }

    public void signupButtonPress(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_CANCELED) {
            finish();
        }
    }
}
