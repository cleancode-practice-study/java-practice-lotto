package controller;

import model.Lotto;
import view.InputView;
import view.OutputView;


public class LottoGameController {
    public void playGame(){
        int amount = InputView.inputLottoAmount();
        OutputView.printLottoAmount(amount);
        OutputView.printLottoNumber();

        String lastWeekLottoNumber = InputView.inputLastWeekWinningNumber();
        int bonusNumber = InputView.inputBonusBallNumber();

        OutputView.printWinningResult();
        // OutputView.printYield();

    }
}
