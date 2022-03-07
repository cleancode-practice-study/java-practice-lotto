package model;

import util.RandomLottoNumber;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 사용자 랜덤 로또 리스트 반환
    public static List<Lotto> getTotalLotto(int count) {
        List<Lotto> userLotto = new ArrayList<>();

        // 랜덤 로또 생성
        for (int i = 0; i < count; i++) {
            Lotto lotto = RandomLottoNumber.getRandomLotto();
            userLotto.add(lotto);
        }

        return userLotto;
    }

    // 로또 구입 갯수 계산 메소드
    public static int getCount(int cost) {
        return cost / LOTTO_TICKET_PRICE;
    }
}
