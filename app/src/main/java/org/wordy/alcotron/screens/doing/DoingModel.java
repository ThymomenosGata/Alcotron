package org.wordy.alcotron.screens.doing;

import java.util.List;
import java.util.Random;

public class DoingModel implements DoingContract.Model {

    private static List<String> mCurrentActions;
    private Random random;

    public DoingModel() {
    }

    public List<String> getActions() {
        return mCurrentActions;
    }

    public void setActions(List<String> actions) {
        mCurrentActions = actions;
    }

    @Override
    public String getRandomAction() {
        random = new Random(mCurrentActions.size());
        int randomNum = random.nextInt();
        String text = mCurrentActions.get(randomNum);
        mCurrentActions.remove(randomNum);
        return text;
    }

}