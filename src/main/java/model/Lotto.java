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

    // 로또 랜덤 숫자 반환
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_TICKET_LENGTH; i++) {
            int number = RandomLottoNumberGenerator.randomLottoNumber(); // 랜덤 로또 번호 생성
            randomNumbers.add(number);
        }

        return randomNumbers;
    }

    public List<Integer> getNumber() {
        return this.numbers;
    }

    // 당첨 번호와 사용자 로또 번호 중 일치하는 번호가 몇개인지 반환
    public int getMatchCount(Lotto winningLotto) {
        List<Integer> user = numbers;
        List<Integer> winning = winningLotto.getNumber();
        List<Integer> win = new ArrayList<>();

        for (Integer i : winning) {
            win.add(Integer.valueOf(String.valueOf(i)));
        }

        user.retainAll(win);

        return user.size();
    }

    // 보너스 번호를 포함하고 있는지 true/false 반환
    public boolean isContainsBonusNumber(int bonusNo) {
        return numbers.contains(bonusNo);
    }
}