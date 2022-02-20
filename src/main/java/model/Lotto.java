package model;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int calculateYield(int buyCost, int winningCost) {
		int yield = winningCost / buyCost;

		return yield;
	}


	// 추가 기능 구현
}
