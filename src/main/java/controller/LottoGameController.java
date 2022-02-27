package controller;

import model.Lotto;
import model.Rank;
import model.User;
import model.WinningLotto;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameController {
    public void play() {
        List<Lotto> userLotto = User.createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = WinningLotto.createWinningLotto(); // 당첨 로또 생성
        printWinningStatisticsResult(userLotto, winningLotto); // 당첨 통계 출력
    }

    // 사용자 총 로또 리스트 출력
    public static void printUserLottoNumber(List<Lotto> userLotto) {
        for (Lotto lotto : userLotto) {
            List<Integer> lottoNumber = lotto.getNumber();

            OutputView.printLottoNumber(lottoNumber);
        }

        System.out.println("");
    }

    // 당첨 통계 출력
    private void printWinningStatisticsResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = initHashMap();

        checkMatch(userLotto, winningLotto, statistics);

        int winningMoney = User.getTotalWinningMoney(statistics);
        int amount = userLotto.size();
        double yield = User.getTotalYield(winningMoney, amount);

        OutputView.printWinningStatisticsResult(statistics);
        OutputView.printTotalYield(yield);
    }

    // HashMap 초기화
    private Map<Rank, Integer> initHashMap() {
        Map<Rank, Integer> lottoResult = new HashMap<>();

        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }

        return lottoResult;
    }

    // 당첨 통계
    private void checkMatch(List<Lotto> userLotto, WinningLotto winningLotto, Map<Rank, Integer> statistics) {
        for (Lotto lotto : userLotto) {
            Rank rank = winningLotto.match(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

}
