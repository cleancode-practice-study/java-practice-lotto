package controller;

import util.RandomLottoNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_TICKET_LENGTH = 6;

    public void playGame() {
        init();
        inputLastWeekLottoNumber();
        printWinningResult();
    }

    private static int calculateLottoAmount(int cost) {
        int amount = cost / LOTTO_TICKET_PRICE;
        return amount;
    }

    private void init() {
        int cost = InputView.inputLottoPurchaseAmount();
        System.out.println("");
        printLottoNumberResult(cost);
        System.out.println("");
    }

    private void printLottoNumberResult(int cost) {
        int count = calculateLottoAmount(cost);

        OutputView.printLottoAmount(count);
        for (int i = 0; i < count; i++) {
            List<String> number = getLottoNumber();
            OutputView.printLottoNumber(number);
        }
    }

    private void inputLastWeekLottoNumber() {
        String lottoNumber = InputView.inputLastWeekWinningNumber();
        int bonusNumber = InputView.inputBonusBallNumber();
    }

    private List<String> getLottoNumber() {
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_TICKET_LENGTH; i++) {
            int number = RandomLottoNumberGenerator.randomLottoNumber();
            String num = Integer.toString(number);
            numbers.add(num);
        }

        return numbers;
    }

    private void printWinningResult() {
        OutputView.printWinningResult();
        // OutputView.printYield();
    }
}
