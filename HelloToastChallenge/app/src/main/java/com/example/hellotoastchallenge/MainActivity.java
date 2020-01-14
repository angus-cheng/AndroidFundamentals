package com.example.hellotoastchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    // mShowCount private member variable required for the reference of show_count.
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // R is a class containing all resources of an application package. R = "Resources" which
        // is everything from res folder.
        setContentView(R.layout.activity_main);
        // findViewById takes ID of a view and returns the View. As this method returns a view, it
        // needs to be casted into a TextView.
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(String.format("%d", mCount));
        }
    }
}
