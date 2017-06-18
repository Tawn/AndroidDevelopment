package assignment07.csc214.instagram.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import assignment07.csc214.instagram.R;
import assignment07.csc214.instagram.login.LoginFragment;

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
        setResult(RESULT_OK);
        finish();

    }

    public void signInButtonPress(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
