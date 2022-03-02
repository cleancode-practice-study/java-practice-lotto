package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private static List<Integer> changeStringArrayToList(String[] winningNumber) {
        int[] numbers = Arrays.stream(winningNumber).mapToInt(Integer::parseInt).toArray(); // string[] > int[]

        return IntStream.of(numbers).boxed().collect(Collectors.toList());
    }

    // 당첨 로또 생성
    public static WinningLotto createWinningLotto() {
        String[] winningNumber = getWinningNumber(); // 지난주 당첨번호 구하기
        int bonusNumber = getBonusNumber(); // 지난주 보너스번호 구하기

        List<Integer> winningNumbers = changeStringArrayToList(winningNumber); // String[] > List
        Lotto lotto = new Lotto(winningNumbers); // 로또 티켓 생성

        return new WinningLotto(lotto, bonusNumber);
    }

    // 지난 주 당첨번호 String > String[] 스플릿
    public static String[] splitWinningNumber(String number) {
        return number.split(",");
    }
}