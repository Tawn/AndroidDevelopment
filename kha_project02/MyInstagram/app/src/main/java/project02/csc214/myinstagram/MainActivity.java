package project02.csc214.myinstagram;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import project02.csc214.myinstagram.database.DatabaseHelper;
import project02.csc214.myinstagram.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        intent = new Intent(this, PagerActivity.class);
        startActivity(intent);

    }
}
