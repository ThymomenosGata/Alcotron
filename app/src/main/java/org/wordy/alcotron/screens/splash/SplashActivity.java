package org.wordy.alcotron.screens.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.choise.ChoiseActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private SplashPresenter presenter;
    private SplashModel model;
    private SharedPreferences.Editor editor;
    private SharedPreferences mFlags;
    public static final String APP_PREFERENCES = "myFlags";
    public static final String APP_PREFERENCES_ADS = "Ads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        model = new SplashModel(getApplication());
        presenter = new SplashPresenter(model, this);
        mFlags = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        editor = mFlags.edit();
        editor.putInt(APP_PREFERENCES_ADS, 0);
        editor.apply();

        if (presenter.isOnline(getApplicationContext())) {
            presenter.getDatas();
        } else {
            navigateToChoise();
        }

    }

    @Override
    public void navigateToChoise() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, ChoiseActivity.class));
                finish();
            }
        }, 2000);
    }
}
