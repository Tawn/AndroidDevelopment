package project01.csc214.duogames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ConnectFourPress(View view) {
        Intent intent = new Intent(MainActivity.this, ConnectFourActivity.class);
        startActivity(intent);
    }

    public void HangManPress(View view) {
        Intent intent = new Intent(MainActivity.this, HangmanActivity.class);
        startActivity(intent);
    }
}
