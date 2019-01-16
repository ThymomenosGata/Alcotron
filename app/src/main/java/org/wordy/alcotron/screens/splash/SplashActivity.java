package org.wordy.alcotron.screens.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.wordy.alcotron.R;
import org.wordy.alcotron.screens.choise.ChoiseActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private SplashPresenter presenter;
    private SplashModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        model = new SplashModel(getApplication());
        presenter = new SplashPresenter(model, this);

        if (presenter.isOnline(getApplicationContext())) {
            presenter.getDatas();
        }

    }

    @Override
    public void navigateToChoise() {
        startActivity(new Intent(SplashActivity.this, ChoiseActivity.class));
    }
}
