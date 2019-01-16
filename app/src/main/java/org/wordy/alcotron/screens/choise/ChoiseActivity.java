package org.wordy.alcotron.screens.choise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.main.MainActivity;

public class ChoiseActivity extends AppCompatActivity {

    private LinearLayout mTruthOrTruth, mTruthOrDoing, mDoinOrDoing, mINever;
    private SharedPreferences mFlags;
    private Editor editor;
    public static final String APP_PREFERENCES = "myFlags";
    public static final String APP_PREFERENCES_FLAG = "Flag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise);

        mFlags = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        mTruthOrTruth = findViewById(R.id.trurth_or_truth);
        mTruthOrDoing = findViewById(R.id.truth_or_doin);
        mDoinOrDoing = findViewById(R.id.doing_or_doing);
        mINever = findViewById(R.id.i_never);
        editor = mFlags.edit();

        mTruthOrDoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(APP_PREFERENCES_FLAG, 0);
                editor.apply();
                Intent intent = new Intent(ChoiseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mDoinOrDoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(APP_PREFERENCES_FLAG, 1);
                editor.apply();
                Intent intent = new Intent(ChoiseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mTruthOrTruth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(APP_PREFERENCES_FLAG, 2);
                editor.apply();
                Intent intent = new Intent(ChoiseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mINever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt(APP_PREFERENCES_FLAG, 3);
                editor.apply();
                Intent intent = new Intent(ChoiseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
