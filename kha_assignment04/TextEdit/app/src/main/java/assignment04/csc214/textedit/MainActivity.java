package assignment04.csc214.textedit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String SET_BOLD = "assignment04.csc214.BOLD";
    static final String SET_ITALICS = "assignment04.csc214.ITALICS";
    static final String SET_UNDERLINE = "assignment04.csc214.UNDERLINE";

    private TextView mMainText;
    private static final int RC_FONT = 2;
    boolean textIsUnderlined;
    public static final String SAVED_MESSAGE = "MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainText = (TextView)findViewById(R.id.text_edit);

        if(savedInstanceState != null) {
            String message = savedInstanceState.getString(SAVED_MESSAGE);
            mMainText.setText(message);
        }

    }

    // Landscape Portrait (Restore State)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Typeface typeface = mMainText.getTypeface();
        String saveText =  mMainText.getText().toString();
        savedInstanceState.putBoolean(SET_BOLD, typeface.isBold());
        savedInstanceState.putBoolean(SET_ITALICS, typeface.isItalic());
        savedInstanceState.putBoolean(SET_UNDERLINE, textIsUnderlined);
        savedInstanceState.putString(SAVED_MESSAGE, saveText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        boolean bold = savedInstanceState.getBoolean(SET_BOLD);
        boolean italics = savedInstanceState.getBoolean(SET_ITALICS);
        boolean underline = savedInstanceState.getBoolean(SET_UNDERLINE);
        mMainText.setText(savedInstanceState.getString(SAVED_MESSAGE));
        updateFont(bold, italics, underline);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Font
        if( resultCode != RESULT_CANCELED ) {
            boolean bold = data.getBooleanExtra(SET_BOLD, false);
            boolean italics = data.getBooleanExtra(SET_ITALICS, false);
            boolean underline = data.getBooleanExtra(SET_UNDERLINE, false);
            updateFont(bold, italics, underline);
        }
    }

    public void changeFontButtonPress(View view) {
        Intent intent = new Intent(this, ChangeFontActivity.class);
        Typeface typeface = mMainText.getTypeface();
        intent.putExtra(SET_BOLD, typeface.isBold());
        intent.putExtra(SET_ITALICS, typeface.isItalic());
        intent.putExtra(SET_UNDERLINE, textIsUnderlined);
        startActivityForResult(intent, RC_FONT);
    }

    public void changeMessageButtonPress(View view) {
    }

    private void updateFont(boolean bold, boolean italics, boolean underline) {
        Typeface typeface = mMainText.getTypeface();
        int font_settings = Typeface.NORMAL;

        // Bold and Italics
        if(bold && italics) {
            font_settings = Typeface.BOLD_ITALIC;

        } else if (bold) {
            font_settings = Typeface.BOLD;

        } else if (italics) {
            font_settings = Typeface.ITALIC;

        }

        // Underline
        if(underline) {
            CharSequence message = mMainText.getText();
            SpannableString content = new SpannableString(message);
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            mMainText.setText(content);
            textIsUnderlined = true;
        }
        else { // Reset
            mMainText.setText(mMainText.getText().toString());
            textIsUnderlined = false;
        }


        Typeface newTypeface = Typeface.create(typeface, font_settings);
        mMainText.setTypeface(newTypeface);

    }
}
