package com.example.activitylifecycleandstatechallnege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shopping_items extends AppCompatActivity {

    public static final String EXTRA_ITEM="com.example.android.activitylifecycleandstatechallenge" +
            ".extra.ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_items);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Cheese");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Ham");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Bread");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Crystal");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Sexy legs");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Bicycle");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Soccer ball");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendItemRequest("Fountain pen");
            }
        });
    }

    public void sendItemRequest(String itemRequested) {
        Intent itemRequestIntent = new Intent();
        itemRequestIntent.putExtra(EXTRA_ITEM, itemRequested);
        setResult(RESULT_OK, itemRequestIntent);
        finish();
    }
}
