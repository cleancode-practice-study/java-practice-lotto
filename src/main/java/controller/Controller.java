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

    private Lottoes getLottoes() {
        int lottoPrice = InputView.inputLottoPurchasePrice();
        int lottoCount = GameHelper.getLottoCount(lottoPrice);

        OutputView.printLottoCount(lottoCount);

        Lottoes lottoes = GameHelper.createLottoes(lottoCount);

        OutputView.printLottoNumber(lottoes);
        OutputView.printNextLine();

        return lottoes;
    }

    private WinningLotto getWinningLotto() {
        String winningNumbers = null;
        boolean isValid = false;

        while (!isValid) {
            winningNumbers = InputView.inputWinningLottoNumber();

            isValid = GameHelper.checkDuplicatedNumber(winningNumbers);

            if (!isValid) {
                OutputView.printInvalidLottoNumberError();
            }
        }

        int bonusNum = InputView.inputWinningBonusNumber();

        return GameHelper.createWinningLotto(winningNumbers, bonusNum);
    }

    private void printResult(WinningLotto winningLotto, Lottoes lottoes) {
        WinningResult lottoWinResult = GameHelper.getLottoWinResult(winningLotto, lottoes);

        double yield = GameHelper.getYield(lottoWinResult, lottoes.getLottoesCount() * LOTTO_PRICE_PER_ONE);

        OutputView.printLottoResult(lottoWinResult);
        OutputView.printLottoYield(yield);
    }

}
