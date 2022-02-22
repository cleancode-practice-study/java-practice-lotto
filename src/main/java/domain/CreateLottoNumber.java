package domain;

import java.util.*;

public class CreateLottoNumber {
    static private final int LOTTO_NUM_PER_ONE_LINE = 6;
    static private final int LOTTO_NUM_START_INCLUSIVE = 1;
    static private final int LOTTO_NUM_END_INCLUSIVE = 45;

    private static final Random random = new Random();

    public static List<Integer> createLottosNumber() {
        Set<Integer> lottosDeduplicated = new HashSet<>();

        while (lottosDeduplicated.size() < LOTTO_NUM_PER_ONE_LINE) {
            lottosDeduplicated.add(getRandomNumber(LOTTO_NUM_START_INCLUSIVE, LOTTO_NUM_END_INCLUSIVE));
        }

        return new ArrayList<>(lottosDeduplicated);
    }

    public static int getRandomNumber(int start, int end) {
        return random.nextInt(end) + start;
    }
}
