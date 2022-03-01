package model;

import java.util.List;

import static controller.LottoGameController.getBonusNumber;
import static controller.LottoGameController.getWinningNumber;

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

    // 당첨 로또 생성
    public static WinningLotto createWinningLotto() {
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();

        Lotto lotto = new Lotto(winningNumber); // 로또 티켓 생성

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    // 지난 주 당첨번호 String > String[] 스플릿
    public static String[] splitWinningNumber(String number) {
        return number.split(",");
    }
}