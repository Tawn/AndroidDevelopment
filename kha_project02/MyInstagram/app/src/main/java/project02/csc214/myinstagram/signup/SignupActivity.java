package project02.csc214.myinstagram.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import project02.csc214.myinstagram.R;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    // Return to Main Activity
    public void loginButtonPress(View view) {
        mUsername = (EditText)findViewById(R.id.et_signup_username);
        mPassword = (EditText)findViewById(R.id.et_signup_password);

        Log.i(TAG, "onClick: Login button pressed\nUser:" +
                mUsername.getText() + "\nPassword: " +
                mPassword.getText());

        finish();
    }

    public void signupButtonPress(View view) {
        Log.i(TAG, "signupButtonPress: Creating new user into database.");
        setResult(RESULT_OK);
        // Database
        EditText etNewUsername = (EditText)findViewById(R.id.et_signup_username);
        EditText etNewPassword = (EditText)findViewById(R.id.et_signup_password);
        finish();

    }

    public void signInButtonPress(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
