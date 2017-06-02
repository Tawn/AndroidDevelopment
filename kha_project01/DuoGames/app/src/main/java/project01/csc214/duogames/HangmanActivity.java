package project01.csc214.duogames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static project01.csc214.duogames.R.drawable.stage1;

public class HangmanActivity extends AppCompatActivity {

    private HangmanGame game;
    private EditText etGuess;
    private int resultOfGuess, playerTurn, attemptsLeft;
    private String ALREADY_GUESSED_MESSAGE, WRONG_WORD_MESSAGE, WINNER_MESSAGE, WRONG_LETTER_MESSAGE,
                    CORRECT_LETTER_MESSAGE, LOSE_MESSAGE;
    private ImageView ivStatus;
    private TextView tvPlayerTurn;
    private String PLAYERONE, PLAYERTWO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        game = new HangmanGame();
        playerTurn = 1;
        etGuess = (EditText)findViewById(R.id.guess);
        ALREADY_GUESSED_MESSAGE = "Already guessed that letter";
        WRONG_WORD_MESSAGE = "Wrong Guess";
        WRONG_LETTER_MESSAGE = "Wrong letter";
        WINNER_MESSAGE = "Player " + playerTurn + " wins!";
        CORRECT_LETTER_MESSAGE = "You got it!";
        LOSE_MESSAGE = "You Lose. Next Players Turn";
        PLAYERONE = "Player 1:";
        PLAYERTWO = "Player 2:";
        attemptsLeft = 8;
        ivStatus = (ImageView)findViewById(R.id.game_status);
        tvPlayerTurn = (TextView)findViewById(R.id.player_turn);

    }

    public void MainMenuPress(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void playerWordGuess(View view) {
        String guess = etGuess.getText().toString();

        int resultOfGuess = game.check(guess);
        switch (resultOfGuess) {
            case 0: Toast.makeText(this, ALREADY_GUESSED_MESSAGE, Toast.LENGTH_SHORT).show();
                break;
            case 1: Toast.makeText(this, WINNER_MESSAGE, Toast.LENGTH_SHORT).show();
                break;
            case 2: Toast.makeText(this, CORRECT_LETTER_MESSAGE, Toast.LENGTH_SHORT).show();
                break;
            case 3: Toast.makeText(this, WRONG_WORD_MESSAGE, Toast.LENGTH_SHORT).show();
                attemptsLeft--;
                break;
            case 4: Toast.makeText(this, WRONG_LETTER_MESSAGE, Toast.LENGTH_SHORT).show();
                attemptsLeft--;
                break;
            default:
                break;
        }

        updateImage(attemptsLeft);

    }

    public void updateImage(int attemptsLeft) {
        switch (attemptsLeft) {
            case 7: ivStatus.setImageResource(R.drawable.stage1);
                break;
            case 6: ivStatus.setImageResource(R.drawable.stage2);
                break;
            case 5: ivStatus.setImageResource(R.drawable.stage3);
                break;
            case 4: ivStatus.setImageResource(R.drawable.stage4);
                break;
            case 3: ivStatus.setImageResource(R.drawable.stage5);
                break;
            case 2: ivStatus.setImageResource(R.drawable.stage6);
                break;
            case 1: ivStatus.setImageResource(R.drawable.stage7);
                break;
            case 0: ivStatus.setImageResource(R.drawable.stage8);
                Toast.makeText(this, LOSE_MESSAGE, Toast.LENGTH_SHORT).show();
                if(playerTurn == 1) {
                    playerTurn = 2;
                    tvPlayerTurn.setText(PLAYERTWO);

                } else {
                    playerTurn = 1;
                    tvPlayerTurn.setText(PLAYERONE);
                }
            default:
                break;
        }
    }
}
