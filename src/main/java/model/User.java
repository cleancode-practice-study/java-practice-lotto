package model;

import view.InputView;

import java.util.List;

import static model.InputValidator.isValidateCost;
import static model.Lotto.getRandomNumber;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 구매 금액 입력
    private static int inputCost() {
        int cost = 0;

        do {
            cost = InputView.inputLottoPurchaseCost(); // 구매 금액 입력
        } while (!(isValidateCost(cost)));

        System.out.println("");

        return cost;
    }

    // 사용자 구매 갯수 반환
    public static int getLottoCount() {
        int cost = inputCost();
        int count = calculateCount(cost); // 구매 갯수 계산

        return count;
    }

    // 사용자 구매 갯수 계산 메소드
    private static int calculateCount(int cost) {
        int count = cost / LOTTO_TICKET_PRICE;

        return count;
    }

    // 랜덤 숫자로 생성된 사용자 로또 반환
    public static Lotto getRandomLotto() {
        List<Integer> lottoNumber = getRandomNumber();
        Lotto lotto = new Lotto(lottoNumber);

        return lotto;
    }
}