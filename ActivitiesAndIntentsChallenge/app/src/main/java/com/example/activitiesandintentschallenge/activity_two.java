package com.example.activitiesandintentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class activity_two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        TextView textView = findViewById(R.id.textView);
        TextView titleTextView = findViewById(R.id.text1_title);

        String passage = getIntent().getStringExtra(MainActivity.BUTTON_KEY);

        if (passage != null) {
            if (passage.equals(this.getString(R.string.button_1_passage))) {
                titleTextView.setText(this.getString(R.string.button_1_title));
                textView.setText(this.getText(R.string.button_1_passage));
            }
            if (passage.equals(this.getString(R.string.button_2_passage))) {
                titleTextView.setText(this.getString(R.string.button_2_title));
                textView.setText(this.getText(R.string.button_2_passage));
            }
            if (passage.equals(this.getString(R.string.button_3_passage))) {
                titleTextView.setText(this.getString(R.string.button_3_title));
                textView.setText(this.getText(R.string.button_3_passage));
            }
        }
    }
}
