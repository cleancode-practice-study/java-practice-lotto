package controller;

import model.Lotto;
import model.Rank;
import model.Statistics;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static model.InputValidator.*;
import static model.Statistics.initStatistics;
import static model.User.getLottoCount;
import static model.User.getRandomLotto;
import static model.WinningLotto.createWinningLotto;
import static model.WinningLotto.splitWinningNumber;

public class LottoGameController {
    // 사용자 로또 생성
    private static List<Lotto> createUserLotto() {
        int cost = inputCost(); // 사용자 로또 구입 금액 입력
        int count = getCount(cost);
        printPurchaseAmountMessage(count); // 사용자 로또 구입 갯수 메세지 출력
        List<Lotto> userLotto = getUserLotto(count); // 사용자 구입한 로또 리스트 받기

        return userLotto;
    }

    private static int getCount(int cost) {
        int count = getLottoCount(cost);

        return count;
    }

    // 사용자 로또 구입 갯수 메세지 출력
    private static void printPurchaseAmountMessage(int count) {
        OutputView.printPurchaseAmountMessage(count); // 구매 갯수 메세지 출력
    }

    private static List<Lotto> getUserLotto(int count) {
        List<Lotto> userLotto = new ArrayList<>();

        // 랜덤 로또 생성
        for (int i = 0; i < count; i++) {
            Lotto lotto = getRandomLotto();
            userLotto.add(lotto);
        }

        OutputView.printUserLotto(userLotto); // 사용자가 구매한 로또 번호 출력

        return userLotto;

    }

    // 구매 금액 입력
    public static int inputCost() {
        int cost = 0;

        do {
            cost = InputView.inputLottoPurchaseCost(); // 구매 금액 입력
        } while (!(isValidateCost(cost)));

        System.out.println("");

        return cost;
    }

    // 지난 주 당첨 번호 입력
    public static List<Integer> inputWinningNumber() {
        String[] winningNumber;

        do {
            String lottoNumber = InputView.inputWinningNumber(); // 지난주 당첨번호 입력
            winningNumber = splitWinningNumber(lottoNumber); // 당첨번호 , 기준으로 split
        }
        while (!(isValidateWinningNumberLength(winningNumber)));

        List<Integer> winningNumbers = new ArrayList(Arrays.asList(winningNumber));

        return winningNumbers;
    }

    // 지난 주 보너스 번호 입력
    private static int inputBonusNumber() {
        int bonusNumber = 0;

        do {
            bonusNumber = InputView.inputBonusNumber();
            System.out.println("");
        } while (!(isValidateBonusNumber(bonusNumber)));

        return bonusNumber;
    }

    public void play() {
        List<Lotto> userLotto = createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = createWinningLotto(); // 당첨 로또 생성
        printWinningStatisticsResult(userLotto, winningLotto); // 당첨 통계 출력
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