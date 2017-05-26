package assignment02.csc214.thanhslayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private int mCount = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutActivity.this, R.string.First_Toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount--;
                if(mCount == 80) { // Quicker Example
                    Toast.makeText(LayoutActivity.this, R.string.Reset,
                            Toast.LENGTH_SHORT).show();
                    mCount = 100;
                }
                ((TextView)findViewById(R.id.text)).setText(Integer.toString(mCount));
            }
        });

        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LayoutActivity.this, R.string.Second_Toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
