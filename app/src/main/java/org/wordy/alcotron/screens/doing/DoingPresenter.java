package org.wordy.alcotron.screens.doing;

import android.support.v4.app.Fragment;

public class DoingPresenter implements DoingContract.Presenter {

    private DoingModel model;
    private DoingContract.View view;

    public DoingPresenter(DoingModel model, DoingContract.View view) {
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
