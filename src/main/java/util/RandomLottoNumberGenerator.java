package util;

import java.util.Random;

public class RandomLottoNumberGenerator {
    private static final int MAX_RANDOM_NUMBER = 45;

    public static int randomLottoNumber() {
        Random random = new Random();

        return random.nextInt(MAX_RANDOM_NUMBER) + 1;
    }
}

