package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.*;


public class Controller {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    public void run() {
        Lottoes lottoes = getLottoes();
        WinningLotto winningLotto = getWinningLotto();
        printResult(winningLotto, lottoes);
    }

    // 랜덤 로또 받아서 출력
    private Lottoes getLottoes() {
        // 얼마 어치의 로또를 구매할 건지 입력
        int lottoPrice = InputView.inputLottoPurchasePrice();
        int lottoCount = GameHelper.getLottoCount(lottoPrice);

        // 몇 개의 로또를 구매했는 지 출력
        OutputView.printLottoCount(lottoCount);

        Lottoes lottoes = GameHelper.createLottoes(lottoCount);

        // 구매한 로또 번호 출력
        OutputView.printLottoNumber(lottoes);

        OutputView.printNextLine();

        return lottoes;
    }

    // 당첨 로또 받기
    private WinningLotto getWinningLotto() {
        String winningNumbers = null;
        boolean isValid = false;

        // 당첨 번호 입력을 중복으로 했을 경우 다시 입력 받도록 함.
        while (!isValid) {
            // 당첨 로또 번호 받기
            winningNumbers = InputView.inputWinningLottoNumber();
            // 중복인지 확인
            isValid = GameHelper.checkDuplicatedNumber(winningNumbers);

            // 중복이면 오류 메시지 출력 후 다시 받도록 함.
            if (!isValid) {
                OutputView.printInvalidLottoNumberError();
            }
        }

        // 당첨 로또 보너스 받기
        int bonusNum = InputView.inputWinningBonusNumber();

        return GameHelper.createWinningLotto(winningNumbers, bonusNum);
    }

    // 모델에게 값 받아 로또 당첨 결과 출력
    private void printResult(WinningLotto winningLotto, Lottoes lottoes) {
        // 당첨 결과 구하기
        Map<Rank, Integer> lottoWinResult = GameHelper.getLottoWinResult(winningLotto, lottoes);

        // 수익률 구하기
        double yield = GameHelper.getYield(lottoWinResult, lottoes.getLottoesCount() * LOTTO_PRICE_PER_ONE);

        // 당첨 통계 출력
        OutputView.printLottoResult(lottoWinResult);
        OutputView.printLottoYield(yield);
    }

}
