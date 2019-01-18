package org.wordy.alcotron.screens.truth;

import java.util.List;
import java.util.Random;

public class TruthModel implements TruthContract.Model {

    private static List<String> mCurrentTruths;
    private Random random;

    public TruthModel() {
    }

    public List<String> getNevers() {
        return mCurrentTruths;
    }

    public void setNevers(List<String> nevers) {
        mCurrentTruths = nevers;
    }

    @Override
    public String getRandomAction() {
        random = new Random(mCurrentTruths.size());
        int randomNum = random.nextInt();
        String text = mCurrentTruths.get(randomNum);
        mCurrentTruths.remove(randomNum);
        return text;
    }
}
