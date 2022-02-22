package controller;

import domain.Lotto;
import view.InputView;
import view.OutputView;

public class Controller {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    public void run() {
        int lottoPrice = getLottoPrice();
        int lottoCount = getLottoCount(lottoPrice);
        printLottoCount(lottoCount);
    }

    private int getLottoPrice() {
        return InputView.inputLottoPurchasePrice();
    }

    // 로또 금액 받아서 몇개 산 건지 계산
    private int getLottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE_PER_ONE;
    }

    private void printLottoCount(int lottoCount) {
        System.out.println();
        OutputView.printLottoCount(lottoCount);
    }

    // 개수만큼 로또 객체 생성하기.
}
