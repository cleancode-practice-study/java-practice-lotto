package controller;

import domain.Lotto;
import view.InputView;

public class Controller {
    public static void run() {
        int lottoPrice = getLottoPrice();
    }

    private static int getLottoPrice() {
        return InputView.inputLottoPurchasePrice();
    }
}
