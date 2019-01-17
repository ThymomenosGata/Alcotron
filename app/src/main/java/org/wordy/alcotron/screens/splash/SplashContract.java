package org.wordy.alcotron.screens.splash;

import android.content.Context;

public interface SplashContract {

    interface View {
        void navigateToChoise();
    }

    interface Presenter {
        boolean isOnline(Context context);

        void getDatas();
    }

    interface Model {
        boolean getActions();

        boolean getTruth();
    }

}
