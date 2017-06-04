package project01.csc214.duogames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameChangeActivity extends AppCompatActivity {

    private EditText etPlayerOne, etPlayerTwo;

    // Stored information
    private int playerStartHangman, playerStartConnectFour;
    private String playerOneName, playerTwoName;
    private int p1Score, p2Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_change);
        Intent intent = getIntent();

        // Get Stored information
        playerStartConnectFour = intent.getIntExtra(MainActivity.CONNECT_FOUR_TURN, 1);
        playerStartHangman = intent.getIntExtra(MainActivity.HANGMAN_TURN, 1);
        playerOneName = intent.getStringExtra(MainActivity.P1NAME);
        playerTwoName = intent.getStringExtra(MainActivity.P2NAME);
        p1Score = intent.getIntExtra(MainActivity.P1SCORE, 1);
        p2Score = intent.getIntExtra(MainActivity.P2SCORE, 1);


        etPlayerOne = (EditText)findViewById(R.id.p1_name);
        etPlayerTwo = (EditText)findViewById(R.id.p2_name);

        etPlayerOne.setText(intent.getStringExtra(MainActivity.P1NAME));
        etPlayerTwo.setText(intent.getStringExtra(MainActivity.P2NAME));

    }

    public void submitPress(View view) {
        Intent intent = new Intent();

        // Edit Text
        etPlayerOne = (EditText)findViewById(R.id.p1_name);
        etPlayerTwo = (EditText)findViewById(R.id.p2_name);
        playerOneName = etPlayerOne.getText().toString();
        playerTwoName = etPlayerTwo.getText().toString();


        intent.putExtra(MainActivity.P1SCORE, p1Score);
        intent.putExtra(MainActivity.P2SCORE, p2Score);
        intent.putExtra(MainActivity.P1NAME, playerOneName);
        intent.putExtra(MainActivity.P2NAME, playerTwoName);
        intent.putExtra(MainActivity.HANGMAN_TURN, playerStartHangman);
        intent.putExtra(MainActivity.CONNECT_FOUR_TURN, playerStartConnectFour);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void cancelPress(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

}
