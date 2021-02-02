package me.atyre.cutclean;

import java.util.Random;

public class NumberUtil {

    public static int generateRandomNumberWithLooting(int n1, int n2, int lootingLevel) {
        Random random = new Random();
        if (lootingLevel > 3) {
            return 0;
        }

        if (lootingLevel < 0) {
            return 0;
        }

        int newN2 = n2 + lootingLevel;
        return random.nextInt(newN2 - n1) + n1;
    }
}
