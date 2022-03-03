package controller;

import model.InputValidator;
import model.Lotto;
import view.InputView;

public class InputController {
    // 구입 금액 반환
    public static int inputCost() {
        int cost = 0;

        do {
            cost = InputView.inputLottoPurchaseCost(); // view 호출, 구입 금액 입력
        } while (!(InputValidator.isValidateCost(cost)));

        System.out.println("");

        return cost;
    }

    // 지난 주 당첨 번호 반환
    public static String[] inputWinningNumber() {
        String[] winningNumber;

        do {
            String lottoNumber = InputView.inputWinningNumber(); // view 호출, 지난주 당첨번호 입력
            winningNumber = Lotto.splitNumbers(lottoNumber); // 당첨번호 쉼표표 기준으 split
        }
        while (!(InputValidator.isValidateWinningNumberLength(winningNumber)));

        return winningNumber;
    }

    // 지난 주 보너스 번호 반환
    public static int inputBonusNumber() {
        int bonusNumber = 0;

        do {
            bonusNumber = InputView.inputBonusNumber(); // view 호출, 지난주 보너스번호 입력
            System.out.println("");
        } while (!(InputValidator.isValidateBonusNumber(bonusNumber)));

        return bonusNumber;
    }
}
