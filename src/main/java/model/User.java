package model;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static controller.LottoGameController.printUserLottoNumber;
import static model.InputValidator.isValidateCost;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 사용자 로또 생성
    public static List<Lotto> createUserLotto() {
        return getRandomLottoNumber(getPurchaseAmount());
    }

    // 구매한 로또 갯수만큼 사용자 총 로또 리스트 반환
    public static List<Lotto> getRandomLottoNumber(int amount) {
        List<Lotto> userLotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = Lotto.getRandomNumber();
            Lotto lotto = new Lotto(lottoNumber);
            userLotto.add(lotto);
        }

        printUserLottoNumber(userLotto);

        return userLotto;
    }

    // 구매 갯수 반환
    private static int getPurchaseAmount() {
        int cost = inputCost();
        int amount = calculateCount(cost); // 구매 갯수 계산

        OutputView.printPurchaseAmountMessage(amount); // 구매 갯수 메세지 출력

        return amount;
    }

    // 구매 금액 입력
    private static int inputCost() {
        int cost = LOTTO_TICKET_PRICE;

        do {
            cost = InputView.inputLottoPurchaseCost(); // 구매 금액 입력
        } while (!(isValidateCost(cost)));

        System.out.println("");

        return cost;
    }

    // 구매 갯수 계산 메소드
    public static int calculateCount(int cost) {
        int count = cost / LOTTO_TICKET_PRICE;

        return count;
    }

    // 총 당첨금액
    public static int getTotalWinningMoney(Map<Rank, Integer> statistics) {
        int totalWinningMoney = 0;

        for (Rank rank : Rank.values()) {
            int winningMoney = rank.getWinningMoney();
            int amount = statistics.get(rank);

            totalWinningMoney += winningMoney * amount;
        }

        return totalWinningMoney;
    }

    // 총 수익률
    public static double getTotalYield(double winningMoney, int amount) {
        double amountPaid = (amount * LOTTO_TICKET_PRICE);
        double yield = winningMoney / amountPaid;

        return yield;
    }

}
