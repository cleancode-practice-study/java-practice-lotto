package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 매개변수로 받은 숫자로 생성된 로또 반환
    public static Lotto getLotto(List<Integer> numbers) {
        return new Lotto(numbers);
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