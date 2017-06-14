package assignment06.csc214.listhandling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import assignment06.csc214.listhandling.listview.ListViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }
}
