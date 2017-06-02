package project01.csc214.duogames;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectFourActivity extends AppCompatActivity {

    private ConnectFourGame mGame;

    private boolean playerOneTurn, validMove, exitConfirm;
    private ImageView mPosition;
    private int columnOneRow, columnTwoRow,columnThreeRow,columnFourRow,
            columnFiveRow, columnSixRow, columnSevenRow;
    private int playerTurn;
    private String ERROR_MESSAGE, EXIT_MESSAGE, PLAYER_ONE_TURN, PLAYER_TWO_TURN;
    private RelativeLayout mC4;
    private TextView mPlayerTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four);

        // Initializing Game
        mGame = new ConnectFourGame();

        // Initialize variables
        playerOneTurn = true;
        playerTurn = 1;
        columnOneRow = 6; columnTwoRow = 6; columnThreeRow = 6; columnFourRow = 6;
        columnFiveRow = 6; columnSixRow = 6; columnSevenRow = 6;
        ERROR_MESSAGE = "Invalid Move"; // can't pass row 1
        EXIT_MESSAGE = "Press MAIN MENU again to confirm";
        PLAYER_ONE_TURN = "Player 1 Turn";
        PLAYER_TWO_TURN = "Player 2 Turn";
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

    public void columnOnePress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnOneRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.one_six);
                mGame.setPiece(0, 5, playerTurn);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.one_five);
                mGame.setPiece(0, 4, playerTurn);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.one_four);
                mGame.setPiece(0, 3, playerTurn);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.one_three);
                mGame.setPiece(0, 2, playerTurn);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.one_two);
                mGame.setPiece(0, 1, playerTurn);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.one_one);
                mGame.setPiece(0, 0, playerTurn);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 1
            columnOneRow--;

            checkResult();
        }

    }

    public void columnTwoPress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnTwoRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.two_six);
                mGame.setPiece(1, 5, playerTurn);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.two_five);
                mGame.setPiece(1, 4, playerTurn);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.two_four);
                mGame.setPiece(1, 3, playerTurn);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.two_three);
                mGame.setPiece(1, 2, playerTurn);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.two_two);
                mGame.setPiece(1, 1, playerTurn);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.two_one);
                mGame.setPiece(1, 0, playerTurn);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 2
            columnTwoRow--;

            checkResult();

        }

    }

    public void columnThreePress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnThreeRow) {
            case 6:
                mPosition = (ImageView) findViewById(R.id.three_six);
                mGame.setPiece(2, 5, playerTurn);
                break;
            case 5:
                mPosition = (ImageView) findViewById(R.id.three_five);
                mGame.setPiece(2, 4, playerTurn);
                break;
            case 4:
                mPosition = (ImageView) findViewById(R.id.three_four);
                mGame.setPiece(2, 3, playerTurn);
                break;
            case 3:
                mPosition = (ImageView) findViewById(R.id.three_three);
                mGame.setPiece(2, 2, playerTurn);
                break;
            case 2:
                mPosition = (ImageView) findViewById(R.id.three_two);
                mGame.setPiece(2, 1, playerTurn);
                break;
            case 1:
                mPosition = (ImageView) findViewById(R.id.three_one);
                mGame.setPiece(2, 0, playerTurn);
                break;
            default:
                Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 3
            columnThreeRow--;

            checkResult();

        }

    }

    public void columnFourPress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnFourRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.four_six);
                mGame.setPiece(3, 5, playerTurn);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.four_five);
                mGame.setPiece(3, 4, playerTurn);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.four_four);
                mGame.setPiece(3, 3, playerTurn);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.four_three);
                mGame.setPiece(3, 2, playerTurn);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.four_two);
                mGame.setPiece(3, 1, playerTurn);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.four_one);
                mGame.setPiece(3, 0, playerTurn);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 4
            columnFourRow--;

            checkResult();

        }

    }

    public void columnFivePress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnFiveRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.five_six);
                mGame.setPiece(4, 5, playerTurn);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.five_five);
                mGame.setPiece(4, 4, playerTurn);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.five_four);
                mGame.setPiece(4, 3, playerTurn);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.five_three);
                mGame.setPiece(4, 2, playerTurn);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.five_two);
                mGame.setPiece(4, 1, playerTurn);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.five_one);
                mGame.setPiece(4, 0, playerTurn);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 5
            columnFiveRow--;

            checkResult();

        }

    }

    public void columnSixPress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnSixRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.six_six);
                mGame.setPiece(5, 5, playerTurn);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.six_five);
                mGame.setPiece(5, 4, playerTurn);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.six_four);
                mGame.setPiece(5, 3, playerTurn);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.six_three);
                mGame.setPiece(5, 2, playerTurn);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.six_two);
                mGame.setPiece(5, 1, playerTurn);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.six_one);
                mGame.setPiece(5, 0, playerTurn);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 6
            columnSixRow--;

            checkResult();

        }

    }
    public void columnSevenPress(View view) {
        validMove = true;
        exitConfirm = false;

        // Obtain Position
        switch (columnSevenRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.seven_six);
                mGame.setPiece(6, 5, playerTurn);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.seven_five);
                mGame.setPiece(6, 4, playerTurn);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.seven_four);
                mGame.setPiece(6, 3, playerTurn);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.seven_three);
                mGame.setPiece(6, 2, playerTurn);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.seven_two);
                mGame.setPiece(6, 1, playerTurn);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.seven_one);
                mGame.setPiece(6, 0, playerTurn);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            mC4 = (RelativeLayout)findViewById(R.id.c4_menu);
            mPlayerTurn = (TextView)findViewById(R.id.player_turn);

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                mC4.setBackgroundColor(Color.YELLOW);
                mPlayerTurn.setText(PLAYER_TWO_TURN);
                playerTurn = 2;
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                mC4.setBackgroundColor(Color.RED);
                mPlayerTurn.setText(PLAYER_ONE_TURN);
                playerTurn = 1;
                playerOneTurn = true;
            }

            //Decrement row 7
            columnSevenRow--;

            checkResult();

        }

    }

    public void checkResult() {
        if(mGame.checkResult() == 1) {
            Toast.makeText(this, "Player 1 Wins!!!!!", Toast.LENGTH_SHORT).show();
        } else
        if(mGame.checkResult() == 2) {
            Toast.makeText(this, "Player 2 Wins!!!!!", Toast.LENGTH_SHORT).show();
        }

    }

}