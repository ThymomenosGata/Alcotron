package org.wordy.alcotron.screens.doing;

import android.support.v4.app.Fragment;

public interface DoingContract {

    interface View {
        void loadInitialFragment(Fragment fragment);
        void setTextAction(String task);
    }

    interface Presenter {
        void setTextTask();
        void navigateToMainFragment(Fragment fragment);
    }

    interface Model {
        String getRandomAction();
    }

}
