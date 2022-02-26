package model;

import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		return Rank.valueOf(getCountOfMatch(userLotto), getMatchBonus(userLotto));
	}

	public int getCountOfMatch(Lotto userLotto) {
		List<Integer> user = userLotto.getNumber();
		List<Integer> winning = lotto.getNumber();

		user.retainAll(winning);

		return user.size();
	}

	public boolean getMatchBonus(Lotto userLotto) {
		return userLotto.getNumber().contains(bonusNo);
	}
}
