package assignment04.csc214.textedit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class ChangeMessageActivity extends Activity
        implements ChangeMessageFragment.MessageChangeListener {

    // To save data to resend to Main Activity
    private Boolean cbBold, cbItalic, cbUnderline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_message);

        Intent intent = getIntent();
        // Saved Font Settings
        cbBold = intent.getBooleanExtra(MainActivity.SET_BOLD, false);
        cbItalic = intent.getBooleanExtra(MainActivity.SET_ITALICS, false);
        cbUnderline = intent.getBooleanExtra(MainActivity.SET_UNDERLINE, false);

        // Set Fragment
        ChangeMessageFragment fragment = new ChangeMessageFragment();
        fragment.setArguments(getIntent().getExtras());
        getFragmentManager()
                .beginTransaction()
                .add(R.id.frame_message, fragment)
                .commit();
    }

    // Transferring data back to Main Menu w/changes
    @Override
    public void messageChanged(CharSequence message) {
        Intent data = new Intent();
        data.putExtra(MainActivity.SAVED_MESSAGE, message);
        data.putExtra(MainActivity.SET_BOLD, cbBold);
        data.putExtra(MainActivity.SET_ITALICS, cbItalic);
        data.putExtra(MainActivity.SET_UNDERLINE, cbUnderline);
        setResult(RESULT_OK, data);
        finish();
    }

    // No Changes made
    @Override
    public void messageCanceled() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
