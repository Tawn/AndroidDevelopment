package mobappdev.demo.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mobappdev.demo.finalexam.problem1.ProblemOneFirstActivity;
import mobappdev.demo.finalexam.problem2.ProblemTwoActivity;
import mobappdev.demo.finalexam.problem3.AActivity;
import mobappdev.demo.finalexam.problem3.BActivity;
import mobappdev.demo.finalexam.problem4.ImageDownloaderActivity;

public class MainActivity extends AppCompatActivity {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void problemOneClicked(View view) {
        mIntent = new Intent(this, ProblemOneFirstActivity.class);
        startActivity(mIntent);
    }

    public void problemTwoClicked(View view) {
        mIntent = new Intent(this, ProblemTwoActivity.class);
        startActivity(mIntent);
    }

    public void problemThreeAClicked(View view) {
        mIntent = new Intent(this, AActivity.class);
        startActivity(mIntent);
    }

    public void problemThreeBClicked(View view) {
        mIntent = new Intent(this, BActivity.class);
        startActivity(mIntent);
    }

    public void problemFourClicked(View view) {
        mIntent = new Intent(this, ImageDownloaderActivity.class);
        startActivity(mIntent);
    }
}
