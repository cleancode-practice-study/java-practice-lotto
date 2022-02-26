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
        List<Lotto> userNumbers = getUserLottoNumber(); // 구매한 갯수만큼 유저 로또 번호 리스트
        System.out.println("");
        Lotto winningNumbers = inputLastWeekLottoNumber(); // 지난 주 당첨번호 입력
        int winningBnsNumber = inputLastWeekBonusNumber(); // 지난 주 보너스 번호 입력

        printWinningResult();
    }

    private int initUserLotto() {
        int cost = InputView.inputLottoPurchaseAmount(); // 구매금액 입력
        System.out.println("");

        return cost;
    }

    private int printPurchaseCountMessage(int cost) {
        int count = calculateLottoAmount(cost); // 구매 금액 > 구매 갯수로 변환
        OutputView.printPurchaseCount(count); // 구매 갯수 메세지 출력

        return count;
    }

    private List<Lotto> getUserLottoNumber() {
        List<Lotto> userLotto = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        int cost = initUserLotto();

        int count = printPurchaseCountMessage(cost);
        for (int i = 0; i < count; i++) {
            number = Lotto.getLottoNumber();
            OutputView.printLottoNumber(number); // 한 장의 로또 번호 6개 출력, 구매한 결과 출력
        }

        Lotto lotto = new Lotto(number);
        userLotto.add(lotto);

        return userLotto;
    }

    // 구매 갯수 계산 메소드
    private static int calculateLottoAmount(int cost) {
        int count = cost / LOTTO_TICKET_PRICE;
        return count;
    }

    private String[] splitLastWeekNumber(String number) {
        return number.split(",");
    }

    private Lotto inputLastWeekLottoNumber() {
        String lottoNumber = InputView.inputLastWeekWinningNumber(); // 지난 주 당첨번호 입력

        String[] number = splitLastWeekNumber(lottoNumber);
        List<Integer> numbers = new ArrayList(Arrays.asList(number));
        Lotto winningLotto = new Lotto(numbers);

        return winningLotto;
    }

    private int inputLastWeekBonusNumber() {
        int bonusNumber = InputView.inputBonusBallNumber(); // 보너스 번호 입력
        System.out.println("");

        return bonusNumber;
    }

    private void printWinningResult() {
        OutputView.printWinningResult();
        // OutputView.printYield(yield);
    }
}
