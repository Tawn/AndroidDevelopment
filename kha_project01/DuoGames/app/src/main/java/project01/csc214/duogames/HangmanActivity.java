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

    // Saved Instances
    private String player1_name, player2_name;
    private int player1_score, player2_score;

    // Game Displays
    private ImageView ivStatus;
    private TextView tvPlayerTurn, tvLetterUsed, tvWordStatus;
    private EditText etGuess;

    // Integers
    private int playerTurn, attemptsLeft, guessCount;
    private int player1_guesses, player2_guesses;
    private int playerStartTurnHangman, playerStartTurnConnectFour;

    // Game Messages
    private String ALREADY_GUESSED_MESSAGE, WRONG_WORD_MESSAGE, WINNER_MESSAGE;
    private String CORRECT_LETTER_MESSAGE, LOSE_MESSAGE, EXIT_MESSAGE;
    private String WRONG_LETTER_MESSAGE, displayGuessed, wordStatus;
    private String PLAYER_TWO, START;

    // Boolean
    private boolean exitConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        // Game
        game = new HangmanGame();
        START = "DELETE YOUR INPUT BEFORE PASSING THE PHONE TO THE OTHER PLAYER!";
        Toast.makeText(this, START, Toast.LENGTH_LONG).show();
        // Game Start
        attemptsLeft = 8;
        guessCount = 0;
        player1_guesses = 0;
        player2_guesses = 0;

        // Display Setting
        etGuess = (EditText)findViewById(R.id.guess);
        ivStatus = (ImageView)findViewById(R.id.game_status);
        tvLetterUsed = (TextView)findViewById(R.id.letter_used);
        tvWordStatus = (TextView)findViewById(R.id.word_status);
        tvPlayerTurn = (TextView)findViewById(R.id.player_turn);

        // Message Set
        ALREADY_GUESSED_MESSAGE = "Already guessed that letter";
        WRONG_WORD_MESSAGE = "Wrong Guess";
        WRONG_LETTER_MESSAGE = "Wrong letter";
        CORRECT_LETTER_MESSAGE = "You got it!";
        LOSE_MESSAGE = "You Lose. Next Players Turn";
        displayGuessed = "Used: ";
        EXIT_MESSAGE = "Press MAIN MENU again to confirm";

        // Word Setup
        wordStatus = game.getStatusDisplay();
        tvWordStatus.setText(wordStatus);

        // Retrieve current results
        Intent intent = getIntent();

        TextView tvPlayer1Score = (TextView)findViewById(R.id.p1_score);
        TextView tvPlayer2Score = (TextView)findViewById(R.id.p2_score);
        TextView tvPlayer1Name = (TextView)findViewById(R.id.player1);
        TextView tvPlayer2Name = (TextView)findViewById(R.id.player2);

        player1_score = intent.getIntExtra(MainActivity.P1SCORE, 0);
        player2_score = intent.getIntExtra(MainActivity.P2SCORE, 0);
        player1_name = intent.getStringExtra(MainActivity.P1NAME);
        player2_name = intent.getStringExtra(MainActivity.P2NAME);

        String p1ScoreString = Integer.toString(player1_score);
        String p2ScoreString = Integer.toString(player2_score);

        tvPlayer1Score.setText(p1ScoreString);
        tvPlayer2Score.setText(p2ScoreString);
        tvPlayer1Name.setText(player1_name);
        tvPlayer2Name.setText(player2_name);

        playerStartTurnConnectFour = intent.getIntExtra(MainActivity.CONNECT_FOUR_TURN, 1);

        // Determining Which Player start
        playerStartTurnHangman = intent.getIntExtra(MainActivity.HANGMAN_TURN, 1);
        if(playerStartTurnHangman == 1) {
            tvPlayerTurn.setText(player1_name + "'s Turn");
            PLAYER_TWO = player2_name + "'s Turn";
        } else {
            tvPlayerTurn.setText(player2_name + "'s Turn");
            PLAYER_TWO = player1_name + "'s Turn";
        }
        playerTurn = 1;
    }

    public void MainMenuPress(View view) {
        // If Main Menu is pressed Twice in a Row
        if(exitConfirm) {
            setResult(RESULT_CANCELED);
            finish();

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
            case 1: win();
                break;
            case 2: Toast.makeText(this, CORRECT_LETTER_MESSAGE, Toast.LENGTH_SHORT).show();
                break;
            case 3: Toast.makeText(this, WRONG_WORD_MESSAGE, Toast.LENGTH_SHORT).show();
                attemptsLeft--;
                if(playerTurn == 1) {
                    player1_guesses++;
                } else {
                    player2_guesses++;
                }
                break;
            case 4: Toast.makeText(this, WRONG_LETTER_MESSAGE, Toast.LENGTH_SHORT).show();
                attemptsLeft--;

                if(playerTurn == 1) {
                    player1_guesses++;
                } else {
                    player2_guesses++;
                }
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
                playerTurn = 2;
                tvPlayerTurn.setText(PLAYER_TWO);
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

    // Game won
    public void win() {
        // If both players had a turn
        if(playerTurn == 2) {
            Intent intent = new Intent();

            if(player1_guesses < player2_guesses) {
                if (playerStartTurnHangman == 1) {
                    WINNER_MESSAGE = player1_name + " wins!";
                    player1_score++;
                } else {
                    WINNER_MESSAGE = player2_name + " wins!";
                    player2_score++;
                }
            } else if (player2_guesses < player1_guesses) {
                if (playerStartTurnHangman == 1) {
                    WINNER_MESSAGE = player2_name + " wins!";
                    player2_score++;
                } else {
                    WINNER_MESSAGE = player1_name + " wins!";
                    player1_score++;
                }
            } else {
                WINNER_MESSAGE = "Draw!";
            }

            Toast.makeText(this, WINNER_MESSAGE, Toast.LENGTH_SHORT).show();
            if (playerStartTurnHangman == 1) {
                Toast.makeText(this, player1_name + " miss: " + player1_guesses, Toast.LENGTH_LONG).show();
                Toast.makeText(this, player2_name + " miss: " + player2_guesses, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, player2_name + " miss: " + player1_guesses, Toast.LENGTH_LONG).show();
                Toast.makeText(this, player1_name + " miss: " + player2_guesses, Toast.LENGTH_LONG).show();
            }

            if (playerTurn == 1) {
                Toast.makeText(this, player1_name + " Score +1", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, player2_name + " Score +1", Toast.LENGTH_SHORT).show();
            }
            intent.putExtra(MainActivity.P1SCORE, player1_score);
            intent.putExtra(MainActivity.P2SCORE, player2_score);
            intent.putExtra(MainActivity.P1NAME, player1_name);
            intent.putExtra(MainActivity.P2NAME, player2_name);
            intent.putExtra(MainActivity.CONNECT_FOUR_TURN, playerStartTurnConnectFour);

            // Switch start turns
            if (playerStartTurnHangman == 1) {
                playerStartTurnHangman = 2;
            } else {
                playerStartTurnHangman = 1;
            }

            intent.putExtra(MainActivity.HANGMAN_TURN, playerStartTurnHangman);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            if(playerStartTurnHangman == 1) {
                Toast.makeText(this, player2_name + " turn", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, player1_name + " turn", Toast.LENGTH_SHORT).show();
            }
            playerTurn = 2;
            tvPlayerTurn.setText(PLAYER_TWO);
            gameReset();

        }
    }
}
