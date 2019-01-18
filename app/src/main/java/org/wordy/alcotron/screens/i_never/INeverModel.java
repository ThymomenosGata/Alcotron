package org.wordy.alcotron.screens.i_never;

import java.util.List;
import java.util.Random;

public class INeverModel implements INeverContract.Model {

    private static List<String> mCurrentNevers;
    private Random random;

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
        random = new Random(mCurrentNevers.size());
        int randomNum = random.nextInt();
        String text = mCurrentNevers.get(randomNum);
        mCurrentNevers.remove(randomNum);
        return text;
    }
}
