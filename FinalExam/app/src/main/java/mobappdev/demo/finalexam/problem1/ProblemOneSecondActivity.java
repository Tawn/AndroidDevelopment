package mobappdev.demo.finalexam.problem1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import mobappdev.demo.finalexam.MainActivity;
import mobappdev.demo.finalexam.R;

public class ProblemOneSecondActivity extends LifecycleLogger {

    public static final String TAG = "P2SecondActivity";
    public static final String SUBTRACT_KEY = "second_activity_subtract";
    public static final String RESULT_KEY = "second_activity_result";
    private TextView tvResult, tvFirstOperand, tvSecondOperand;
    private String powResult;
    private EditText etSubOperand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_one_second);
        Log.i(TAG, "onCreate: second activity");
        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        // Set First Operand
        String firstOperand = data.getString(ProblemOneFirstActivity.OP1_KEY);
        tvFirstOperand = (TextView)findViewById(R.id.tv_op1);
        tvFirstOperand.setText(firstOperand);

        // Set Second Operand
        String secondOperand = data.getString(ProblemOneFirstActivity.OP2_KEY);
        tvSecondOperand = (TextView)findViewById(R.id.tv_op2);
        tvSecondOperand.setText(secondOperand);

        // Set Result
        powResult = data.getString(ProblemOneFirstActivity.RESULT_KEY);
        tvResult = (TextView)findViewById(R.id.tv_result);
        tvResult.setText(powResult);

        // Initialize EditText
        etSubOperand = (EditText)findViewById(R.id.et_subtract);

    }

    public void subtractClicked(View view) {
        // Pass subtract operand to first activity
        String subOperand = etSubOperand.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(SUBTRACT_KEY, subOperand);
        intent.putExtra(RESULT_KEY, powResult);
        setResult(RESULT_OK, intent);
        finish();
    }
}
