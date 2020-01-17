package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    // mShowCount private member variable required for the reference of show_count. TextView
    // shows text to user.
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
        if (mCount == 10) {
            mShowCount.setText(R.string.kicks10);
        }
        if (mCount == 20) {
            mShowCount.setText(R.string.kicks20);
        }
        if (mCount == 30) {
            mShowCount.setText(R.string.kicks30);
        }
        if (mCount == 40) {
            mShowCount.setText(R.string.kicks40);
        }
    }
}
