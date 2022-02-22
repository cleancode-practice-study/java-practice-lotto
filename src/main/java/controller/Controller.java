package controller;

import domain.CreateLottoNumber;
import domain.Lotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class Controller {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    public void run() {
        List<Lotto> lottoes = createLottoes();
    }

    private List<Lotto> createLottoes() {
        int lottoPrice = getLottoPrice();
        int lottoCount = getLottoCount(lottoPrice);

        printLottoCount(lottoCount);

        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0 ; i < lottoCount ; i++) {
            Lotto lotto = createOneLotto();
            lottoes.add(lotto);
        }

        return lottoes;
    }

    // 얼마 어치의 로또를 구매할 건지 입력
    private int getLottoPrice() {
        return InputView.inputLottoPurchasePrice();
    }

    // 로또 금액 받아서 몇개 산 건지 계산
    private int getLottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE_PER_ONE;
    }

    // 몇 개의 로또를 구매했는 지 출력
    private void printLottoCount(int lottoCount) {
        System.out.println();
        OutputView.printLottoCount(lottoCount);
    }

    // 랜덤 숫자로 이루어진 하나의 로또 객체 생성하기.
    private Lotto createOneLotto() {
        List<Integer> lottoNums = CreateLottoNumber.createLottosNumber();
        return new Lotto(lottoNums);
    }
}
