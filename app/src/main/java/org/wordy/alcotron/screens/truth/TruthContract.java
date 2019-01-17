package org.wordy.alcotron.screens.truth;

import android.support.v4.app.Fragment;

public interface TruthContract {

    interface View {
        void loadInitialFragment(Fragment fragment);
        void setTextAction(String task);
    }

    interface Presenter {
        void navigateToMainFragment(Fragment fragment);
        void setTextTask();
    }

    interface Model {
        String getRandomAction();
    }

}
