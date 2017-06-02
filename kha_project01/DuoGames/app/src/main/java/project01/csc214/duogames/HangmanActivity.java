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

    // Game
    private HangmanGame game;

    // Members
    private ImageView ivStatus;
    private TextView tvPlayerTurn, tvLetterUsed, tvWordStatus;
    private EditText etGuess;

    // Integers
    private int playerTurn, attemptsLeft, guessCount;

    // String w/Messages
    private String ALREADY_GUESSED_MESSAGE, WRONG_WORD_MESSAGE, WINNER_MESSAGE, WRONG_LETTER_MESSAGE,
                    CORRECT_LETTER_MESSAGE, LOSE_MESSAGE, EXIT_MESSAGE,
            displayGuessed, wordStatus,
            PLAYER_ONE, PLAYER_TWO;

    // Boolean
    private boolean exitConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        // Game
        game = new HangmanGame();

        // Integers
        playerTurn = 1;
        attemptsLeft = 8;
        guessCount = 0;

        // Members
        etGuess = (EditText)findViewById(R.id.guess);
        ivStatus = (ImageView)findViewById(R.id.game_status);
        tvLetterUsed = (TextView)findViewById(R.id.letter_used);
        tvWordStatus = (TextView)findViewById(R.id.word_status);
        tvPlayerTurn = (TextView)findViewById(R.id.player_turn);

        // Strings
        ALREADY_GUESSED_MESSAGE = "Already guessed that letter";
        WRONG_WORD_MESSAGE = "Wrong Guess";
        WRONG_LETTER_MESSAGE = "Wrong letter";
        WINNER_MESSAGE = "Player " + playerTurn + " wins!";
        CORRECT_LETTER_MESSAGE = "You got it!";
        LOSE_MESSAGE = "You Lose. Next Players Turn";
        PLAYER_ONE = "Player 1:";
        PLAYER_TWO = "Player 2:";
        displayGuessed = "Used: ";
        EXIT_MESSAGE = "Press MAIN MENU again to confirm";

        // Word Setup
        wordStatus = game.getStatusDisplay();
        tvWordStatus.setText(wordStatus);
    }

    public void MainMenuPress(View view) {
        // If Main Menu is pressed Twice in a Row
        if(exitConfirm) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else { // If other buttons are pressed instead
            Toast.makeText(this, EXIT_MESSAGE, Toast.LENGTH_SHORT).show();
            exitConfirm = true;

        }
    }

    public void playerWordGuess(View view) {
        String guess = etGuess.getText().toString();
        exitConfirm = false;
        int resultOfGuess = game.check(guess);

        // Check guess result
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

        // Word Status Update
        wordStatus = game.getStatusDisplay();
        tvWordStatus.setText(wordStatus);

        updateImage(attemptsLeft);
        guessCount = game.getLetterCount();
        String[] alreadyGuessed = game.getGuessedLetters();

        // Update Used Words
        if(guess.length() == 1) {
            for (int i = 0; i < guessCount; i++) {
                if (i == 0)
                    displayGuessed = "Used: [" + alreadyGuessed[i];
                else if (i == alreadyGuessed.length - 1)
                    displayGuessed += ", " + alreadyGuessed[i];
                else
                    displayGuessed += ", " + alreadyGuessed[i];
            }
            displayGuessed += "]";
            tvLetterUsed.setText(displayGuessed);
        }

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
                    tvPlayerTurn.setText(PLAYER_TWO);

                } else {
                    playerTurn = 1;
                    tvPlayerTurn.setText(PLAYER_ONE);
                }

                // Reset Game
                gameReset();

            default:
                break;
        }
    }

    // Game Reset
    public void gameReset() {
        game.reset();
        ivStatus.setImageResource(R.drawable.stage0);
        attemptsLeft = 8;
        // Word Status Update
        wordStatus = game.getStatusDisplay();
        tvWordStatus.setText(wordStatus);
    }
}
