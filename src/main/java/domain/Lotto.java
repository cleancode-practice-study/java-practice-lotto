package domain;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void printLottoNum() {
		System.out.println(numbers);
	}

	// 추가 기능 구현
}
