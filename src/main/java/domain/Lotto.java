package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void printLottoNum() {
		System.out.println(numbers);
	}

	public int countOfMatch (Lotto lotto) {
		List<Integer> matchNumber = new ArrayList<>(lotto.numbers);
		matchNumber.retainAll(this.numbers);

		return matchNumber.size();
	}

	public boolean countOfBonus(int bonus) {
		return numbers.contains(bonus);
	}

	// 추가 기능 구현
}
