package controller;

import domain.CreateLottoNumber;
import domain.Lotto;
import domain.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Controller {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    public void run() {
        List<Lotto> lottoes = createLottoes();
        WinningLotto winningLotto = createWinningLotto();
    }

    // 랜덤 로또 생성
    private List<Lotto> createLottoes() {
        int lottoPrice = getLottoPrice();
        int lottoCount = getLottoCount(lottoPrice);

        printLottoCount(lottoCount);

        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createOneLotto();
            lottoes.add(lotto);
        }

        printLottoNumber(lottoes);

        System.out.println();

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

    // 구매한 로또 번호 출력
    private void printLottoNumber(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            OutputView.printLottoNumber(lotto);
        }
    }

    // 당첨 로또 객체 생성
    private WinningLotto createWinningLotto() {
        boolean isValid = false;
        Set<Integer> winningNumberForCheck = null;

        // 당첨 번호 입력을 중복으로 했을 경우 다시 입력 받도록 함.
        while (!isValid) {
            String winningNum = getWinningLottoNumber();

            winningNumberForCheck = splitWinnigLottoNumber(winningNum);

            isValid = checkDuplicatedNumber(winningNumberForCheck);

            InputView.checkValidWinningLottoNumber(isValid);
        }

        int bonusNum = getWinningBonusNumber();

        List<Integer> winningLottoNumber = new ArrayList<>(winningNumberForCheck);

        Lotto lotto = new Lotto(winningLottoNumber);

        return new WinningLotto(lotto, bonusNum);
    }

    // 당첨 로또 번호 받기
    private String getWinningLottoNumber() {
        return InputView.inputWinningLottoNumber();
    }

    // 당첨 로또 보너스 받기
    private int getWinningBonusNumber() {
        return InputView.inputWinningBonusNumber();
    }

    // 입력한 지난번 당첨 로또 번호 split -> List에 담아서 리턴
    private Set<Integer> splitWinnigLottoNumber(String winningNumber) {
        String[] splitNumbers = winningNumber.split(",");
        Set<Integer> winningLottoNumber = new HashSet<>();

        for (String number : splitNumbers) {
            winningLottoNumber.add(Integer.parseInt(number));
        }

        return winningLottoNumber;
    }

    private boolean checkDuplicatedNumber(Set<Integer> winningNumber) {
        return winningNumber.size() == 6;
    }

}
