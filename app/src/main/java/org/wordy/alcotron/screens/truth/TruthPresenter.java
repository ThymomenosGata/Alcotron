package org.wordy.alcotron.screens.truth;

import android.support.v4.app.Fragment;

public class TruthPresenter implements TruthContract.Presenter {

    private TruthModel model;
    private TruthContract.View view;

    public TruthPresenter(TruthModel model, TruthContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void navigateToMainFragment(Fragment fragment) {
        view.loadInitialFragment(fragment);
    }

    @Override
    public void setTextTask() {
        view.setTextAction(model.getRandomAction());
    }

}
