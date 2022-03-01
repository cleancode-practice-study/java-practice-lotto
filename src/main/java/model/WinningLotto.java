package model;

import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.InputValidator.isValidateBonusNumber;
import static model.InputValidator.isValidateWinningNumberLength;

public class WinningLotto {
    private static final int LOTTO_MIN_RANDOM_NUMBER = 1;
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    // 당첨 로또 생성
    public static WinningLotto createWinningLotto() {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();

        Lotto lotto = new Lotto(winningNumber); // 로또 티켓 생성

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    // 지난 주 당첨 번호 입력
    private static List<Integer> inputWinningNumber() {
        String[] winningNumber;

        do {
            String lottoNumber = InputView.inputWinningNumber(); // 지난주 당첨번호 입력
            winningNumber = splitWinningNumber(lottoNumber); // 당첨번호 , 기준으로 split
        }
        while (!(isValidateWinningNumberLength(winningNumber)));

        List<Integer> winningNumbers = new ArrayList(Arrays.asList(winningNumber));

        return winningNumbers;
    }

    // 지난 주 당첨번호 String > String[] 스플릿
    private static String[] splitWinningNumber(String number) {
        return number.split(",");
    }

    public Rank match(Lotto userLotto) {
        int matchCount = userLotto.getMatchCount(lotto);
        boolean matchBonus = userLotto.isContainsBonusNumber(bonusNo);

        return Rank.valueOf(matchCount, matchBonus);
    }

    // 지난 주 보너스 번호 입력
    private static int inputBonusNumber() {
        int bonusNumber = LOTTO_MIN_RANDOM_NUMBER;

        do {
            bonusNumber = InputView.inputBonusNumber();
            System.out.println("");
        } while (!(isValidateBonusNumber(bonusNumber)));

        return bonusNumber;
    }
}