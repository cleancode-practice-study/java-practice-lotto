package model;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = userLotto.getMatchCount(lotto);
        boolean matchBonus = userLotto.isContainsBonusNumber(bonusNo);

        return Rank.valueOf(matchCount, matchBonus);
    }
}