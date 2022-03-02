package controller;

import model.Lotto;
import model.Rank;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

import static model.InputValidator.*;
import static model.Statistics.*;
import static model.User.createUserLotto;
import static model.WinningLotto.createWinningLotto;
import static model.WinningLotto.splitWinningNumber;

public class LottoGameController {
    // 총 수익률 출력
    public static void printTotalYield(List<Lotto> userLotto, int winningMoney) {
        int count = userLotto.size();
        double yield = getTotalYield(winningMoney, count);

        OutputView.printTotalYield(yield);
    }

    // 사용자 구입 로또 리스트 출력
    public static void printUserLotto(List<Lotto> userLotto) {
        OutputView.printUserLotto(userLotto);
    }

    // 구입 금액 반환
    public static int getCost() {
        int cost = 0;

        do {
            cost = InputView.inputLottoPurchaseCost(); // 구입 금액 입력
        } while (!(isValidateCost(cost)));

        System.out.println("");

        return cost;
    }

    // 지난 주 당첨 번호 반환
    public static String[] getWinningNumber() {
        String[] winningNumber;

        do {
            String lottoNumber = InputView.inputWinningNumber(); // 지난주 당첨번호 입력
            winningNumber = splitWinningNumber(lottoNumber); // 당첨번호 쉼표표 기준으 split
        }
        while (!(isValidateWinningNumberLength(winningNumber)));

        return winningNumber;
    }

    // 사용자 로또 구입 갯수 메세지 출력
    public static void printPurchaseAmountMessage(int count) {
        OutputView.printPurchaseAmountMessage(count); // 구매 갯수 메세지 출력
    }

    // 당첨 통계 출력
    public static void printWinningStatistics(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = getWinningStatistics(userLotto, winningLotto);

        OutputView.printWinningStatisticsResult(statistics);
    }

    // 지난 주 보너스 번호 반환
    public static int getBonusNumber() {
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
        printLottoGameResult(userLotto, winningLotto); // 로또 게임 결과 출력
    }
}