package org.wordy.alcotron.screens.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.choise.ChoiseActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        

    }

    private void navigateToChoise() {
        startActivity(new Intent(SplashActivity.this, ChoiseActivity.class));
    }



}
