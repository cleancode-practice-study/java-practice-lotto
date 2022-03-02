package model;

import java.util.ArrayList;
import java.util.List;

import static controller.LottoGameController.*;
import static model.Lotto.getRandomNumber;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 사용자 로또 생성
    public static List<Lotto> createUserLotto() {
        int cost = getCost(); // 사용자 로또 구입 금액 입력
        int count = getCount(cost); // 사용자 로또 구입 갯수 구하기
        printPurchaseAmountMessage(count); // 사용자 로또 구입 갯수 메세지 출력
        List<Lotto> userLotto = getUserRandomLotto(count); // 사용자 구입 로또 리스트 구하기
        printUserLotto(userLotto); // 사용자 구입 로또 리스트 출력

        return userLotto;
    }

    // 랜덤 숫자로 생성된 사용자 로또 한장 반환
    private static Lotto getRandomLotto() {
        List<Integer> lottoNumber = getRandomNumber();

        return new Lotto(lottoNumber);
    }

    // 사용자 랜덤 로또 리스트 반환
    public static List<Lotto> getUserRandomLotto(int count) {
        List<Lotto> userLotto = new ArrayList<>();

        // 랜덤 로또 생성
        for (int i = 0; i < count; i++) {
            Lotto lotto = getRandomLotto();
            userLotto.add(lotto);
        }

        return userLotto;
    }

    // 사용자 로또 구입 갯수 구하기
    public static int getCount(int cost) {
        return calculateCount(cost);
    }

    // 사용자 로또 구입 갯수 계산 메소드
    private static int calculateCount(int cost) {

        return cost / LOTTO_TICKET_PRICE;
    }

}