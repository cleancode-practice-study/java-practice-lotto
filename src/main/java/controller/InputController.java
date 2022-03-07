package controller;

import model.Convert;
import model.Validator;
import view.InputView;

public class InputController {
    // 구입 금액 반환
    public static int inputCost() {
        int cost;

        do {
            cost = InputView.inputLottoPurchaseCost(); // view 호출, 구입 금액 입력
        } while (!(Validator.isValidCost(cost)));

        System.out.println("");

        return cost;
    }

    // 지난 주 당첨 번호 반환
    public static String[] inputWinningNumber() {
        String[] winningNumber;

        do {
            String lottoNumber = InputView.inputWinningNumber(); // view 호출, 지난주 당첨번호 입력
            winningNumber = Convert.splitNumbers(lottoNumber); // model 호출, 당첨번호 쉼표 기준으로 split
        }
        while (!(Validator.isValidNumberLength(winningNumber)));

        return winningNumber;
    }

    // 지난 주 보너스 번호 반환
    public static int inputBonusNumber() {
        int bonusNumber;

        do {
            bonusNumber = InputView.inputBonusNumber(); // view 호출, 지난주 보너스번호 입력
            System.out.println("");
        } while (!(Validator.isValidBonusNumber(bonusNumber)));

        return bonusNumber;
    }
}
