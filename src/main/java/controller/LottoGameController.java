package controller;

import model.Lotto;
import model.Rank;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameController {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void play() {
        List<Lotto> userNumbers = createUserLotto();
        System.out.println("");

        WinningLotto winningLotto = inputLastWeekNumber(); // 지난 주 당첨번호 입력
        Rank rank = winningLotto.match(userNumbers.get(0));
        System.out.println(rank);
        // printWinningStatisticsResult(numbers, userNumbers);
    }

    // 구매 금액 입력
    private int inputCost() {
        int cost = InputView.inputLottoPurchaseCost(); // 구매 금액 입력
        System.out.println("");

        return cost;
    }

    // 구매 갯수 계산 메소드
    private int calculateCount(int cost) {
        int count = cost / LOTTO_TICKET_PRICE;
        return count;
    }

    // 구매 갯수 반환
    private int getPurchaseCount() {
        int cost = inputCost();
        int count = calculateCount(cost); // 구매 갯수 계산

        OutputView.printPurchaseCountMessage(count); // 구매 갯수 메세지 출력

        return count;
    }

    // 사용자 로또 생성
    private List<Lotto> createUserLotto() {
        return getUserNumber(getPurchaseCount());
    }

    // 구매 갯수 만큼 로또 총 티켓 생성
    private List<Lotto> getUserNumber(int count) {
        List<Lotto> userLotto = new ArrayList<>();
        List<Integer> lottoNumber = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumber = Lotto.getRandomNumber();
            Lotto user = new Lotto(lottoNumber);
            userLotto.add(user);
        }

        printUserNumber(userLotto);

        return userLotto; // 총 로또 티켓 반환
    }

    // 사용자 로또 번호 총 출력
    private void printUserNumber(List<Lotto> userLotto) {
        for (int i = 0; i < userLotto.size(); i++) {
            List<Integer> lottoNumber = userLotto.get(i).getNumber();
            OutputView.printUserLottoNumber(lottoNumber); // 한 장의 구매한 로또 번호 6개 출력
        }
    }

    // 지난 주 당첨번호 String > String[] 스플릿
    private String[] splitLastWeekNumber(String number) {
        return number.split(",");
    }

    // 지난 주 당첨 번호 입력
    private WinningLotto inputLastWeekNumber() {
        String lottoNumber = InputView.inputLastWeekWinningNumber(); // 지난주 당첨번호 입력
        int bonusNumber = InputView.inputBonusBallNumber(); // 지난주 보너스번호 입력

        String[] number = splitLastWeekNumber(lottoNumber); // 당첨번호 , 기준으로 split
        List<Integer> numbers = new ArrayList(Arrays.asList(number)); // List로 변환

        Lotto lastWeekNumber = new Lotto(numbers); // 로또 티켓 생성

        WinningLotto winningLotto = new WinningLotto(lastWeekNumber, bonusNumber);

        return winningLotto;
    }

    private void getStatistics(Lotto winningNumber, Lotto userNumber) {
        winningNumber.getNumber();
    }

    // 당첨 통계 출력
    private void printWinningStatisticsResult(Lotto winningNumber, List<Lotto> userLottoNumbers) {
        getStatistics(winningNumber, userLottoNumbers.get(0));
        OutputView.printWinningStatisticsResult();
        // OutputView.printYield(yield);
    }
}
