package project02.csc214.myinstagram;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import project02.csc214.myinstagram.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String USER_KEY = "USER_KEY";
    private String mCurrentUser;
    public static String CURRENT_USER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Log.i(TAG, "onActivityResult: User: " + data.getExtras().getString(USER_KEY));
            CURRENT_USER = data.getExtras().getString(USER_KEY);
            Bundle bundle = data.getExtras();
            mCurrentUser = bundle.getString(USER_KEY);
            Intent intent = new Intent(this, PagerActivity.class);
            intent.putExtra(USER_KEY, mCurrentUser);
            startActivityForResult(intent, 4);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, 1);
        }
    }
}
