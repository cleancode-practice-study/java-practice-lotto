package model;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static controller.LottoGameController.inputCost;
import static model.Lotto.getRandomNumber;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 사용자 로또 생성
    public static List<Lotto> createUserLotto() {
        List<Lotto> userLotto = new ArrayList<>();
        int count = getLottoCount();

        OutputView.printPurchaseAmountMessage(count); // 구매 갯수 메세지 출력

        for (int i = 0; i < count; i++) {
            Lotto lotto = getRandomLotto();
            userLotto.add(lotto);
        }

        OutputView.printUserLotto(userLotto); // 사용자가 구매한 로또 번호 출력

        return userLotto;
    }

    // 사용자 구매 갯수 반환
    public static int getLottoCount() {
        int cost = inputCost();
        int count = calculateCount(cost); // 구매 갯수 계산

        return count;
    }

    // 사용자 구매 갯수 계산 메소드
    public static int calculateCount(int cost) {
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