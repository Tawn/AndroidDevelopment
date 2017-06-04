package assignment04.csc214.textedit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class ChangeFontActivity extends AppCompatActivity {

    private CheckBox cbBold, cbItalic, cbUnderline;
    private String savedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_font);

        Intent intent = getIntent();

        cbBold = (CheckBox)findViewById(R.id.bold_set);
        cbItalic = (CheckBox)findViewById(R.id.italic_set);
        cbUnderline = (CheckBox)findViewById(R.id.underline_set);

        cbBold.setChecked(intent.getBooleanExtra(MainActivity.SET_BOLD, false));
        cbItalic.setChecked(intent.getBooleanExtra(MainActivity.SET_ITALICS, false));
        cbUnderline.setChecked(intent.getBooleanExtra(MainActivity.SET_UNDERLINE, false));
        savedText = intent.getStringExtra(MainActivity.SAVED_MESSAGE);
    }

    public void submitButtonPress(View view) {
        Intent data = new Intent();
        data.putExtra(MainActivity.SET_BOLD, cbBold.isChecked());
        data.putExtra(MainActivity.SET_ITALICS, cbItalic.isChecked());
        data.putExtra(MainActivity.SET_UNDERLINE, cbUnderline.isChecked());
        data.putExtra(MainActivity.SAVED_MESSAGE, savedText);
        setResult(RESULT_OK, data);
        finish();
    }

    public void cancelButtonPress(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

}
