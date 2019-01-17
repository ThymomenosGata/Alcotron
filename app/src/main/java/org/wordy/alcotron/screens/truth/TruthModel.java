package org.wordy.alcotron.screens.truth;

import org.wordy.alcotron.data.tables.Truth;

import java.util.List;
import java.util.Random;

public class TruthModel implements TruthContract.Model {

    private static List<Truth> truths;
    private Random random;

    public TruthModel() {
    }

    public static List<Truth> getNevers() {
        return truths;
    }

    public static void setNevers(List<Truth> nevers) {
        TruthModel.truths = nevers;
    }

    @Override
    public String getRandomAction() {
        random = new Random(truths.size());
        int randomNum = random.nextInt();
        String text = truths.get(randomNum).getName();
        truths.remove(randomNum);
        return text;
    }
}
