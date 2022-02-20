package controller;

import model.Lotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameController {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void play() {
        initUserLottoNumber();
        List<Integer> numbers = inputLastWeekLottoNumber(); // 지난 주 당첨번호, 보너스번호 입력
        printWinningResult();
    }

    private void initUserLottoNumber() {
        int cost = InputView.inputLottoPurchaseAmount(); // 구매금액 입력
        System.out.println("");
        printPurchaseResult(cost); // 구매한 결과 출력
        System.out.println("");
    }

    private void printPurchaseResult(int cost) {
        int count = calculateLottoAmount(cost); // 구매 금액 > 구매 갯수로 변환
        OutputView.printPurchaseCount(count); // 구매 갯수 메세지 출력
        for (int i = 0; i < count; i++) {
            List<Integer> number = Lotto.getLottoNumber();
            OutputView.printLottoNumber(number); // 한 장의 로또 번호 6개 출력
        }
    }

    // 구매 갯수 계산 메소드
    private static int calculateLottoAmount(int cost) {
        int count = cost / LOTTO_TICKET_PRICE;
        return count;
    }

    private String[] splitLastWeekNumber(String number) {
        return number.split(",");
    }

    private List<Integer> inputLastWeekLottoNumber() {
        String lottoNumber = InputView.inputLastWeekWinningNumber(); // 지난 주 당첨번호 입력

        String[] number = splitLastWeekNumber(lottoNumber);
        List<Integer> numbers = new ArrayList(Arrays.asList(number));

        int bonusNumber = InputView.inputBonusBallNumber(); // 보너스 번호 입력
        numbers.add(bonusNumber);
        System.out.println("");

        return numbers;
    }

    private void printWinningResult() {
        OutputView.printWinningResult();
        // OutputView.printYield(yield);
    }
}
