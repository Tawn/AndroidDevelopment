package project01.csc214.multigame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Main Screen Buttons
    int mTotalScore;
    final Context context = this;
    private Button mConnectFour, mTicTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Main Screen
        mTicTacToe = (Button) findViewById(R.id.playTTT);
        mTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // https://www.mkyong.com/android/android-activity-from-one-screen-to-another-screen/
                Intent intent = new Intent(MainActivity.this, TicTacToeActivity.class);
                startActivity(intent);
            }
        });


    }

}
