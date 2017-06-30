package mobappdev.demo.finalexam.problem1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

public class ProblemOneFirstActivity extends LifecycleLogger {

    public static final String TAG = "P1FirstActivity";
    public static final String RESULT_KEY = "first_activity_result";
    public static final String OP1_KEY = "first_activity_op1";
    public static final String OP2_KEY = "first_activity_op2";

    public static final int REQUEST_SECOND = 1;
    private EditText mLeftOperand, mRightOperand;
    private ProblemOneCalculations calculate;

    private TextView tvSubResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: first activity");
        setContentView(R.layout.activity_problem_one_first);

        // Initialize Edit Text Operand 1 and Operand 2
        mLeftOperand = (EditText)findViewById(R.id.et_op1);
        mRightOperand = (EditText)findViewById(R.id.et_op2);
        calculate = new ProblemOneCalculations();

        // Initialize Subtracted Result
        tvSubResult = (TextView)findViewById(R.id.tv_result);
    }


    public void powClicked(View view) {
        // Get operand inputs
        String operand1 = mLeftOperand.getText().toString();
        String operand2 =  mRightOperand.getText().toString();

        // Calculate MVC
        String result = calculate.getPower(operand1, operand2);

        // Pass argument to SecondActivity
        Intent intent = new Intent(this, ProblemOneSecondActivity.class);
        intent.putExtra(RESULT_KEY, result);
        intent.putExtra(OP1_KEY, operand1);
        intent.putExtra(OP2_KEY, operand2);

        // Start new intent for result
        startActivityForResult(intent, REQUEST_SECOND);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_SECOND && resultCode != RESULT_CANCELED) {
            // Get Intent
            String subOperand = data.getExtras().getString(ProblemOneSecondActivity.SUBTRACT_KEY);
            String powResult = data.getExtras().getString(ProblemOneSecondActivity.RESULT_KEY);

            // Subtract from Power Result
            String subResult = calculate.getSub(powResult, subOperand);

            // Set Subtract Result
            tvSubResult.setText(subResult);
        }

    }
}
