package controller;

import view.InputView;
import view.OutputView;

public class LottoGameController {
    public static final int LOTTO_TICKET_PRICE = 1000;

    public void playGame() {
        init();
        inputLastWeekLottoNumber();
        printWinningResult();
    }

    public static int calculateLottoAmount(int cost) {
        int amount = cost / LOTTO_TICKET_PRICE;
        return amount;
    }

    public void init(){
        int cost = InputView.inputLottoPurchaseAmount();
        printLottoNumberResult(cost);
    }

    public void inputLastWeekLottoNumber(){
        String lottoNumber = InputView.inputLastWeekWinningNumber();
        int bonusNumber = InputView.inputBonusBallNumber();
    }

    public void printLottoNumberResult(int cost) {
        int count = calculateLottoAmount(cost);
        OutputView.printLottoAmount(count);
        OutputView.printLottoNumber();
    }

    public void printWinningResult(){
        OutputView.printWinningResult();
        // OutputView.printYield();
    }
}
