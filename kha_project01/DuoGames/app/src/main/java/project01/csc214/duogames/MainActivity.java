package project01.csc214.duogames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int player1_score, player2_score;
    private TextView tvPlayer1Score, tvPlayer2Score;

    private String player1_name, player2_name;
    private TextView tvPlayer1Name, tvPlayer2Name;

    static final String P1NAME = "PLAYER 1 NAME";
    static final String P2NAME = "PLAYER 2 NAME";
    static final String P1SCORE = "PLAYER 1 SCORE";
    static final String P2SCORE = "PLAYER 2 SCORE";

    // Connect 4 Turn & Hangman Turn
    static final String HANGMAN_TURN = "PLAYER TURN HANGMAN";
    static final String CONNECT_FOUR_TURN = "PLAYER TURN CONNECT-FOUR";
    private int hangmanTurn;
    private int connectFourTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Variables
        tvPlayer1Score = (TextView)findViewById(R.id.p1_score);
        tvPlayer2Score = (TextView)findViewById(R.id.p2_score);
//
//        player1_score = Integer.parseInt(tvPlayer1Score.toString());
//        player2_score = Integer.parseInt(tvPlayer2Score.toString());

        tvPlayer1Name = (TextView)findViewById(R.id.player1);
        tvPlayer2Name = (TextView)findViewById(R.id.player2);

        player1_name = tvPlayer1Name.getText().toString();
        player2_name = tvPlayer2Name.getText().toString();

        hangmanTurn = 1;
        connectFourTurn = 1;

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store Name
        savedInstanceState.putString(P1NAME, player1_name);
        savedInstanceState.putString(P2NAME, player2_name);

        // Store Score
        savedInstanceState.putInt(P1SCORE, player1_score);
        savedInstanceState.putInt(P2SCORE, player2_score);

        // Store Game Turns
        savedInstanceState.putInt(HANGMAN_TURN, hangmanTurn);
        savedInstanceState.putInt(CONNECT_FOUR_TURN, connectFourTurn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore Name
        player1_name = savedInstanceState.getString(P1NAME);
        player2_name = savedInstanceState.getString(P2NAME);

        // Restore Score
        player1_score = savedInstanceState.getInt(P1SCORE);
        player2_score = savedInstanceState.getInt(P2SCORE);

        // Restore Game Turns
        hangmanTurn = savedInstanceState.getInt(HANGMAN_TURN);
        connectFourTurn = savedInstanceState.getInt(CONNECT_FOUR_TURN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_CANCELED) {
            player1_score = data.getIntExtra(P1SCORE, 0);
            player2_score = data.getIntExtra(P2SCORE, 0);
            String p1Score = Integer.toString(player1_score);
            String p2Score = Integer.toString(player2_score);
            connectFourTurn = data.getIntExtra(CONNECT_FOUR_TURN, 1);
            hangmanTurn = data.getIntExtra(HANGMAN_TURN, 1);
            tvPlayer1Score.setText(p1Score);
            tvPlayer2Score.setText(p2Score);
        }
    }

    public void ConnectFourPress(View view) {
        Intent intent = new Intent(this, ConnectFourActivity.class);
        intent.putExtra(P1SCORE, player1_score);
        intent.putExtra(P2SCORE, player2_score);
        intent.putExtra(P1NAME, player1_name);
        intent.putExtra(P2NAME, player2_name);
        intent.putExtra(HANGMAN_TURN, hangmanTurn);
        intent.putExtra(CONNECT_FOUR_TURN, connectFourTurn);
        startActivityForResult(intent, 2);
    }

    public void HangManPress(View view) {
        Intent intent = new Intent(this, HangmanActivity.class);
        intent.putExtra(P1SCORE, player1_score);
        intent.putExtra(P2SCORE, player2_score);
        intent.putExtra(P1NAME, player1_name);
        intent.putExtra(P2NAME, player2_name);
        intent.putExtra(HANGMAN_TURN, hangmanTurn);
        intent.putExtra(CONNECT_FOUR_TURN, connectFourTurn);
        startActivityForResult(intent, 2);
    }
}
