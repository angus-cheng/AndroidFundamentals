package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Main activity for the app.
 */
public class MainActivity extends AppCompatActivity {

    // Key for logging value
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Key for the Intent extra
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    // Holds the message to text

    private EditText mMessageEditText;

    private TextView mReplyHeadTextView;

    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get reference to the data fields of the app so they can be accessed.
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        // When Send button clicked, MainActivity sends Intent to Android system to launch
        // activity_second. The below statement is an explicit intent.
        Intent intent = new Intent(this, activity_second.class);
        String message = mMessageEditText.getText().toString();
        // Intent extras are key-value pairs in a Bundle.
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     *
     * @param requestCode integer set when activity launched with startActivityForResult()
     * @param resultCode integer set in the launched activity
     * @param data contains the data from the launched actiivity
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request to respond to
        if (requestCode == TEXT_REQUEST) {
            // Make sure request was successful
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(activity_second.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
