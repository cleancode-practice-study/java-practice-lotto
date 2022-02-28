package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

import static model.InputValidator.isValidateCost;
import static model.Statistics.initStatistics;

public class LottoGameController {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void play() {
        List<Lotto> userLotto = User.createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = WinningLotto.createWinningLotto(); // 당첨 로또 생성
        printWinningStatisticsResult(userLotto, winningLotto); // 당첨 통계 출력
    }

    // 구매 금액 입력
    public static int inputCost() {
        int cost = LOTTO_TICKET_PRICE;

        do {
            cost = InputView.inputLottoPurchaseCost(); // 구매 금액 입력
        } while (!(isValidateCost(cost)));

        System.out.println("");

        return cost;
    }

    // 당첨 통계 결과 출력
    private void printWinningStatisticsResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = initStatistics();

        Statistics.registerMatchStatistics(userLotto, winningLotto, statistics);

        int winningMoney = Statistics.getTotalWinningMoney(statistics);
        int count = userLotto.size();
        double yield = Statistics.getTotalYield(winningMoney, count);

        OutputView.printWinningStatisticsResult(statistics);
        OutputView.printTotalYield(yield);
    }
}