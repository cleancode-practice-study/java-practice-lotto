package model;

import java.util.List;

import static controller.LottoGameController.getCost;
import static controller.LottoGameController.getUserLotto;
import static model.Lotto.getRandomNumber;
import static view.OutputView.printPurchaseAmountMessage;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 사용자 로또 생성
    public static List<Lotto> createUserLotto() {
        int cost = getCost(); // 사용자 로또 구입 금액 입력
        int count = getCount(cost); // 사용자 로또 구입 갯수 구하기
        printPurchaseAmountMessage(count); // 사용자 로또 구입 갯수 메세지 출력
        List<Lotto> userLotto = getUserLotto(count); // 사용자 구입 로또 리스트 구하기

        return userLotto;
    }

    // 사용자 로또 구입 갯수 구하기
    public static int getCount(int cost) {
        int count = calculateCount(cost); // 사용자 구입 금액 > 구입 갯수 계산

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