package project01.csc214.duogames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ConnectFourActivity extends AppCompatActivity {

    private boolean playerOneTurn, validMove;
    private ImageView mPosition;
    private int mColumnOneRow, mColumnTwoRow,mColumnThreeRow,mColumnFourRow,
            mColumnFiveRow, mColumnSixRow, mColumnSevenRow;
    private String ERROR_MESSAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_four);

        // Initialize variables
        playerOneTurn = true;
        mColumnOneRow = 6; mColumnTwoRow = 6; mColumnThreeRow = 6; mColumnFourRow = 6;
        mColumnFiveRow = 6; mColumnSixRow = 6; mColumnSevenRow = 6;
        ERROR_MESSAGE = "Invalid Move"; // can't pass row 1
    }

    public void MainMenuPress(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void columnOnePress(View view) {
        validMove = true;

        // Obtain Position
        switch (mColumnOneRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.one_six);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.one_five);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.one_four);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.one_three);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.one_two);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.one_one);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 1
            mColumnOneRow--;
        }

    }

    public void columnTwoPress(View view) {
        validMove = true;
        // Obtain Position
        switch (mColumnTwoRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.two_six);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.two_five);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.two_four);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.two_three);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.two_two);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.two_one);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 2
            mColumnTwoRow--;
        }

    }

    public void columnThreePress(View view) {
        validMove = true;
        // Obtain Position
        switch (mColumnThreeRow) {
            case 6:
                mPosition = (ImageView) findViewById(R.id.three_six);
                break;
            case 5:
                mPosition = (ImageView) findViewById(R.id.three_five);
                break;
            case 4:
                mPosition = (ImageView) findViewById(R.id.three_four);
                break;
            case 3:
                mPosition = (ImageView) findViewById(R.id.three_three);
                break;
            case 2:
                mPosition = (ImageView) findViewById(R.id.three_two);
                break;
            case 1:
                mPosition = (ImageView) findViewById(R.id.three_one);
                break;
            default:
                Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if (validMove) {

            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 3
            mColumnThreeRow--;
        }

    }

    public void columnFourPress(View view) {
        validMove = true;

        // Obtain Position
        switch (mColumnFourRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.four_six);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.four_five);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.four_four);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.four_three);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.four_two);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.four_one);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 4
            mColumnFourRow--;
        }

    }

    public void columnFivePress(View view) {
        validMove = true;
        // Obtain Position
        switch (mColumnFiveRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.five_six);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.five_five);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.five_four);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.five_three);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.five_two);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.five_one);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 5
            mColumnFiveRow--;
        }

    }

    public void columnSixPress(View view) {
        validMove = true;

        // Obtain Position
        switch (mColumnSixRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.six_six);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.six_five);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.six_four);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.six_three);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.six_two);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.six_one);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 6
            mColumnSixRow--;
        }

    }
    public void columnSevenPress(View view) {
        validMove = true;

        // Obtain Position
        switch (mColumnSevenRow) {
            case 6: mPosition = (ImageView)findViewById(R.id.seven_six);
                break;
            case 5: mPosition = (ImageView)findViewById(R.id.seven_five);
                break;
            case 4: mPosition = (ImageView)findViewById(R.id.seven_four);
                break;
            case 3: mPosition = (ImageView)findViewById(R.id.seven_three);
                break;
            case 2: mPosition = (ImageView)findViewById(R.id.seven_two);
                break;
            case 1: mPosition = (ImageView)findViewById(R.id.seven_one);
                break;
            default: Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
                validMove = false;
                break;
        }

        if(validMove) {
            // Set Piece
            if (playerOneTurn) {
                mPosition.setImageResource(R.mipmap.red_piece);
                playerOneTurn = false;
            } else { // Player Two's Turn
                mPosition.setImageResource(R.mipmap.yellow_piece);
                playerOneTurn = true;
            }

            //Decrement row 7
            mColumnSevenRow--;
        }

    }

}