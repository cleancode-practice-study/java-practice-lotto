package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

import static model.InputValidator.isValidateCost;
import static model.User.calculateCount;

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

    // 구매 갯수 반환
    public static int getPurchaseAmount() {
        int cost = inputCost();
        int amount = calculateCount(cost); // 구매 갯수 계산

        OutputView.printPurchaseAmountMessage(amount); // 구매 갯수 메세지 출력

        return amount;
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
        Map<Rank, Integer> statistics = Statistics.initHashMap();

        checkMatch(userLotto, winningLotto, statistics);

        int winningMoney = Statistics.getTotalWinningMoney(statistics);
        int amount = userLotto.size();
        double yield = Statistics.getTotalYield(winningMoney, amount);

        OutputView.printWinningStatisticsResult(statistics);
        OutputView.printTotalYield(yield);
    }


    // 당첨 통계
    private void checkMatch(List<Lotto> userLotto, WinningLotto winningLotto, Map<Rank, Integer> statistics) {
        for (Lotto lotto : userLotto) {
            Rank rank = winningLotto.match(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

}
