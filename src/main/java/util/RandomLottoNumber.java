package util;

import model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLottoNumber {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;
    private static final int LOTTO_TICKET_LENGTH = 6;

    // 랜덤 숫자로 생성된 로또 반환
    public static Lotto getRandomLotto() {
        List<Integer> randomNumber = getRandomNumbers();

        return new Lotto(randomNumber);
    }

    private static int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }

    // 로또 랜덤 숫자 반환
    private static List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_TICKET_LENGTH; i++) {
            int numbers = RandomLottoNumber.getRandomNumber(); // 랜덤 로또 번호 생성
            randomNumbers.add(numbers);
        }

        return randomNumbers;
    }
}