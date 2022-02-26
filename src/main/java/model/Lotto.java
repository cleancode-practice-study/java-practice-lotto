package model;

import util.RandomLottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_TICKET_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    public static List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_TICKET_LENGTH; i++) {
            int number = RandomLottoNumberGenerator.randomLottoNumber(); // 랜덤 로또 번호 생성
            numbers.add(number);
        }

        return numbers;
	}

}
