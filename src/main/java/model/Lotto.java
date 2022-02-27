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

    public static List<Integer> getRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_TICKET_LENGTH; i++) {
            int number = RandomLottoNumberGenerator.randomLottoNumber(); // 랜덤 로또 번호 생성
            numbers.add(number);
        }

        return numbers;
    }

    public List<Integer> getNumber() {
        return this.numbers;
    }

    // 당첨 번호와 사용자 로또 번호가 일치하는 숫자가 몇개인지 반환
    public int getCountOfMatch(Lotto winningLotto) {
        List<Integer> user = numbers;
        List<Integer> winningNumber = winningLotto.getNumber();

        List<Integer> winning = new ArrayList<>();

        // 오류 해결 부분
        for (int i = 0; i < winningNumber.size(); i++) {
            winning.add(Integer.valueOf(String.valueOf(winningNumber.get(i))));
        }

        user.retainAll(winning);

        return user.size();
    }

    // 보너스 번호를 포함하고 있는지 true/false 반환
    public boolean getMatchBonus(int bonusNo) {
        return numbers.contains(bonusNo);
    }

}
