package org.wordy.alcotron.screens.i_never;

public class INeverPresenter implements INeverContract.Presenter {

    private INeverModel model;
    private INeverContract.View view;

    public INeverPresenter(INeverModel model, INeverContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void setTextTask() {
        view.setTextNever(model.getRandomAction());
    }

}
