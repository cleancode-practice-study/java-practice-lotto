package controller;

import model.Lotto;
import model.Rank;
import model.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static model.InputValidator.*;

public class LottoGameController {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_MIN_RANDOM_NUMBER = 1;
    HashMap<Rank, Integer> statistics = initHashMap();

    public void play() {
        List<Lotto> userLottoes = createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = createWinningLotto(); // 당첨 로또 생성
        printWinningStatistics(winningLotto, userLottoes, statistics);
    }

    // 구매 금액 입력
    private int inputCost() {
        int cost = LOTTO_TICKET_PRICE;
        do {
            cost = InputView.inputLottoPurchaseCost(); // 구매 금액 입력
        } while (!(isValidateCost(cost)));

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
    public List<Lotto> getUserNumber(int count) {
        List<Lotto> userLottoes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = Lotto.getRandomNumber();
            Lotto user = new Lotto(lottoNumber);
            userLottoes.add(user);
        }

        printUserNumber(userLottoes);
        System.out.println("");

        return userLottoes; // 총 로또 티켓 반환
    }

    // 사용자 로또 번호 총 출력
    private void printUserNumber(List<Lotto> userLottoes) {
        for (int i = 0; i < userLottoes.size(); i++) {
            Lotto userLotto = userLottoes.get(i);
            List<Integer> lottoNumber = userLotto.getNumber();

            OutputView.printUserLottoNumber(lottoNumber); // 한 장의 구매한 로또 번호 6개 출력
        }
    }

    // 지난 주 당첨번호 String > String[] 스플릿
    public String[] splitLastWeekNumber(String number) {
        return number.split(",");
    }

    // 지난 주 당첨 번호 입력
    private String[] inputLastWeekNumber() {
        String[] number = new String[6];

        do {
            String lottoNumber = InputView.inputLastWeekWinningNumber(); // 지난주 당첨번호 입력
            number = splitLastWeekNumber(lottoNumber); // 당첨번호 , 기준으로 split
        }
        while (!(isValidateWinningNumberLength(number)));

        return number;
    }

    // 지난 주 보너스 번호 입력
    private int inputBonusNumber() {
        int bonusNumber = LOTTO_MIN_RANDOM_NUMBER;

        do {
            bonusNumber = InputView.inputBonusBallNumber(); // 지난주 보너스번호 입력
            System.out.println("");
        } while (!(isValidateBonusNumber(bonusNumber)));

        return bonusNumber;
    }

    // 당첨 로또 생성
    private WinningLotto createWinningLotto() {
        String[] number = inputLastWeekNumber();
        int bonusNumber = inputBonusNumber();

        List<Integer> numbers = new ArrayList(Arrays.asList(number)); // List로 변환
        Lotto lastWeekNumber = new Lotto(numbers); // 로또 티켓 생성

        WinningLotto winningLotto = new WinningLotto(lastWeekNumber, bonusNumber);

        return winningLotto;
    }

    // 하나의 로또 매치 시켜가면서 그에 따른 당첨 금액과 당첨 통계를 구한다
    private int getTotalWinningMoney(WinningLotto winningLotto, List<Lotto> userLottoes) {
        int totalWinningMoney = 0;

        for (Lotto lotto : userLottoes) {
            Rank rank = winningLotto.match(lotto);
            totalWinningMoney += rank.getWinningMoney();

            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }

        // System.out.println("통계:" + statistics);

        return totalWinningMoney;
    }

    private HashMap<Rank, Integer> initHashMap() {
        HashMap<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);

        return lottoResult;
    }

    private double getYield(int winningMoney, List<Lotto> userLottoes) {
        return (double) winningMoney / (double) (userLottoes.size() * LOTTO_TICKET_PRICE);
    }

    // 당첨 통계 출력
    private void printWinningStatistics(WinningLotto winningLotto, List<Lotto> userLottoes, HashMap winningStatistics) {
        int winningMoney = getTotalWinningMoney(winningLotto, userLottoes);
        double yield = getYield(winningMoney, userLottoes);

        OutputView.printWinningStatisticsResult(winningStatistics);
        OutputView.printTotalYield(yield);
    }
}
