package assignment07.csc214.instagram.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import assignment07.csc214.instagram.R;
import assignment07.csc214.instagram.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        finish();
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
