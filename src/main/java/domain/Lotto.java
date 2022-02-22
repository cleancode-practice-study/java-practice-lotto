package domain;

import java.util.List;

public class Lotto {
	static private final int LOTTO_NUM_PER_ONE_LINE = 6;
	static private final int LOTTO_NUM_START_INCLUSIVE = 1;
	static private final int LOTTO_NUM_END_INCLUSIVE = 45;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}



	// 추가 기능 구현
}
