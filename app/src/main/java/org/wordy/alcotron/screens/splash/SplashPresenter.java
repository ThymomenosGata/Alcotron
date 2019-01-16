package org.wordy.alcotron.screens.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashModel model;
    private SplashContract.View view;

    public SplashPresenter(SplashModel model, SplashContract.View view) {
        this.model = model;
        this.view = view;
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    @SuppressLint("StaticFieldLeak")
    public void getDatas() {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                return model.getTruth() && model.getActions() && model.getNevers();
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (aBoolean) {
                    view.navigateToChoise();
                }
            }
        }.execute();

    }

}
