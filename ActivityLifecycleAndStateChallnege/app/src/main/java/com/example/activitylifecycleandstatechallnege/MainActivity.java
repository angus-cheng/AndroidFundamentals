package com.example.activitylifecycleandstatechallnege;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_ITEM_REQUEST = 1;

    private ArrayList<TextView> mTexts = new ArrayList<>();
    private String mLocation = "";
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mText1 = findViewById(R.id.textView1);
        TextView mText2 = findViewById(R.id.textView2);
        TextView mText3 = findViewById(R.id.textView3);
        TextView mText4 = findViewById(R.id.textView4);
        TextView mText5 = findViewById(R.id.textView5);
        TextView mText6 = findViewById(R.id.textView6);
        TextView mText7 = findViewById(R.id.textView7);
        TextView mText8 = findViewById(R.id.textView8);
        TextView mText9 = findViewById(R.id.textView9);
        TextView mText10 = findViewById(R.id.textView10);

        mTexts.add(mText1);
        mTexts.add(mText2);
        mTexts.add(mText3);
        mTexts.add(mText4);
        mTexts.add(mText5);
        mTexts.add(mText6);
        mTexts.add(mText7);
        mTexts.add(mText8);
        mTexts.add(mText9);
        mTexts.add(mText10);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTexts.get(9).getText().length() != 0) {
                    Snackbar snackbar = Snackbar.make(view, "You cannot purchase anymore items " +
                            "you rich person. I " +
                            "would advise you to look at your items and reconsider your life " +
                            "choices", Snackbar.LENGTH_INDEFINITE);
                    View snackbarView = snackbar.getView();
                    TextView snackbarText =
                            (TextView) snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
                    snackbarText.setMaxLines(5);
                    snackbar.setDuration(10000);
                    snackbar.show();
                }
                launchShoppingItems(view);
            }
        });

        if (savedInstanceState != null) {
            for (int i = 0; i< mTexts.size(); i++) {
                ArrayList<String> savedTexts =
                        new ArrayList<>(savedInstanceState.getStringArrayList("Saved texts"));
                TextView text = findViewById(R.id.textView1);
                text.setText(savedTexts.get(i));
                mTexts.add(text);
            }
        }


    }

    public void launchShoppingItems(View view) {
        Intent intent = new Intent(this, shopping_items.class);
        startActivityForResult(intent, ADD_ITEM_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(shopping_items.EXTRA_ITEM);
                for (int i = 0; i < mTexts.size(); i++) {
                    if (mTexts.get(i).getText().length() == 0) {
                        mTexts.get(i).setText(item);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<String> mTextsStringArray = new ArrayList<>();
        for (int i = 0; i < mTexts.size(); i++) {
            mTextsStringArray.add(mTexts.get(i).getText().toString());
        }
        outState.putStringArrayList("Saved texts", mTextsStringArray);
    }

    public void findClosestShoppingStore(View view) {
        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("Title");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            mLocation = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
         */

        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.alert_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        onCreateView(dialogView, "view", MainActivity.this, null) {
            final EditText text = (EditText) findViewById(R.id.address);
            final Button addressButton = findViewById(R.id.address_button_id);
            addressButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String addressValue = text.getText().toString();
                }
            });
        };
        builder.setView(dialogView);
        builder.setTitle("Find the closest shop for your items");
        builder.setMessage("Enter your location");
        builder.show();
    }

    public void openLocation(String location) {
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
