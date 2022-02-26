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

    // 당첨 번호와 사용자 로또 번호가 일치하는 숫자가 몇개인지 반환
    public int getCountOfMatch(Lotto userLotto) {
        List<Integer> user = userLotto.getNumber();
        List<Integer> winning = lotto.getNumber();

        System.out.println("일치하는 갯수: " + user.size());

        return user.size();
    }

    // 보너스 번호를 포함하고 있는지 true/false 반환
    public boolean getMatchBonus(Lotto userLotto) {
        return userLotto.getNumber().contains(bonusNo);
    }
}
