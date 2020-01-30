package com.example.activitiesandintentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String BUTTON_KEY = "com.example.android.activitiesandintentschallenge" +
            ".BUTTONKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchActivityTwoText3(View view) {
        Intent intent = new Intent(this, activity_two.class);
        intent.putExtra(BUTTON_KEY, this.getString(R.string.button_3_passage));
        startActivity(intent);
    }

    public void launchActivityTwoText2(View view) {
        Intent intent = new Intent(this, activity_two.class);
        intent.putExtra(BUTTON_KEY, this.getString(R.string.button_2_passage));
        startActivity(intent);
    }

    public void launchActivityTwoText1(View view) {
        Intent intent = new Intent(this, activity_two.class);
        intent.putExtra(BUTTON_KEY, this.getString(R.string.button_1_passage));
        startActivity(intent);
    }
}
