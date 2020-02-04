package com.example.activitylifecycleandstatechallnege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_ITEM_REQUEST = 1;

    private ArrayList<TextView> mTexts = new ArrayList<>();

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
                launch_shopping_items(view);
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

    public void launch_shopping_items(View view) {
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
}
