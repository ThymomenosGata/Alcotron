package org.wordy.alcotron.screens.i_never;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class INeverModel implements INeverContract.Model {

    private static List<String> mCurrentNevers;
    private static List<String> mCurrentNeversHelper = new ArrayList<>();
    private static Random random = new Random();

    public INeverModel() {
    }

    public List<String> getNevers() {
        return mCurrentNevers;
    }

    public void setNevers(List<String> nevers) {
        mCurrentNevers = nevers;
    }

    @Override
    public String getRandomAction() {
        if (mCurrentNeversHelper.size() == 0) {
            mCurrentNeversHelper.addAll(mCurrentNevers);
        }
        int randomNum = random.nextInt(mCurrentNeversHelper.size());
        String text = mCurrentNeversHelper.get(randomNum);
        mCurrentNeversHelper.remove(randomNum);
        return text;
    }
}
