package domain;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		int countOfMatch = userLotto.countOfMatch(lotto);
		boolean countOfBonus = userLotto.countOfBonus(bonusNo);

		return Rank.valueOf(countOfMatch, countOfBonus);
	}

}
