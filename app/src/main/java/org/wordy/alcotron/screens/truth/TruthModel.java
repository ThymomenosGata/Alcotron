package org.wordy.alcotron.screens.truth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TruthModel implements TruthContract.Model {

    private static List<String> mCurrentTruths;
    private static List<String> mCurrentTruthsHelper = new ArrayList<>();
    private static Random random = new Random();

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
        if (mCurrentTruthsHelper.size() == 0) {
            mCurrentTruthsHelper.addAll(mCurrentTruths);
        }
        int randomNum = random.nextInt(mCurrentTruthsHelper.size());
        String text = mCurrentTruthsHelper.get(randomNum);
        mCurrentTruthsHelper.remove(randomNum);
        return text;
    }
}
