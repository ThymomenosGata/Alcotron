package org.wordy.alcotron.screens.doing;

import org.wordy.alcotron.data.tables.Action;

import java.util.List;
import java.util.Random;

public class DoingModel implements DoingContract.Model {

    private static List<Action> actions;
    private Random random;

    public DoingModel() {
    }

    public static List<Action> getActions() {
        return actions;
    }

    public static void setActions(List<Action> actions) {
        DoingModel.actions = actions;
    }

    @Override
    public String getRandomAction() {
        random = new Random(actions.size());
        int randomNum = random.nextInt();
        String text = actions.get(randomNum).getName();
        actions.remove(randomNum);
        return text;
    }

}