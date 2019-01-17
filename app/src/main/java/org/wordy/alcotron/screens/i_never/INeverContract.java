package org.wordy.alcotron.screens.i_never;

public interface INeverContract {

    interface View {
        void setTextNever(String text);
    }

    interface Presenter {
        void setTextTask();
    }

    interface Model {
        String getRandomAction();
    }

}
