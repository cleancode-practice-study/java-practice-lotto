package model;

import java.util.ArrayList;
import java.util.List;

import static controller.LottoGameController.getLottoCount;
import static controller.LottoGameController.printUserLotto;
import static model.Lotto.getRandomNumber;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 사용자 로또 생성
    public static List<Lotto> createUserLotto() {
        List<Lotto> userLotto = new ArrayList<>();
        int amount = getLottoCount();

        for (int i = 0; i < amount; i++) {
            Lotto lotto = getRandomLotto();
            userLotto.add(lotto);
        }

        printUserLotto(userLotto);

        return userLotto;
    }

    // 랜덤 숫자로 생성된 로또 반환
    public static Lotto getRandomLotto() {
        List<Integer> lottoNumber = getRandomNumber();
        Lotto lotto = new Lotto(lottoNumber);

        return lotto;
    }

    // 구매 갯수 계산 메소드
    public static int calculateCount(int cost) {
        int count = cost / LOTTO_TICKET_PRICE;

        return count;
    }
}