package org.wordy.alcotron.screens.i_never;

import org.wordy.alcotron.data.tables.I_Never;

import java.util.List;
import java.util.Random;

public class INeverModel implements INeverContract.Model {

    private static List<I_Never> nevers;
    private Random random;

    public INeverModel() {
    }

    public static List<I_Never> getNevers() {
        return nevers;
    }

    public static void setNevers(List<I_Never> nevers) {
        INeverModel.nevers = nevers;
    }

    @Override
    public String getRandomAction() {
        random = new Random(nevers.size());
        int randomNum = random.nextInt();
        String text = nevers.get(randomNum).getName();
        nevers.remove(randomNum);
        return text;
    }
}
