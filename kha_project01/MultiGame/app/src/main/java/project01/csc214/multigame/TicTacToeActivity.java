package project01.csc214.multigame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tkha on 5/29/17.
 */

public class TicTacToeActivity extends AppCompatActivity {

    // Tic-Tac-Toe Buttons + Back Button
    private Button mTopLeft, mTopCenter, mTopRight,
            mLeft, mCenter, mRight,
            mBottomLeft, mBottomCenter, mBottomRight,
            mBack;

    // Tic-Tac-Toe
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);


        mCenter = (Button) findViewById(R.id.Center);
        mCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.Center)).setText("X");
            }
        });


    }
    
}
