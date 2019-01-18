package org.wordy.alcotron.screens.doing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoingModel implements DoingContract.Model {

    private static List<String> mCurrentActions;
    private static List<String> mCurrentActionsHelper = new ArrayList<>();
    private static Random random = new Random();

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
        if (mCurrentActionsHelper.size() == 0) {
            mCurrentActionsHelper.addAll(mCurrentActions);
        }
        int randomNum = random.nextInt(mCurrentActionsHelper.size());
        String text = mCurrentActionsHelper.get(randomNum);
        mCurrentActionsHelper.remove(randomNum);
        return text;
    }

}