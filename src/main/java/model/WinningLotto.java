package model;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
        // 당첨번호와, 사용자번호 비교?
        // Rank.valueOf()
        return null;
    }
}
