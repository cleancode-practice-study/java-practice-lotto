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

    public void play() {
        List<Lotto> userLotto = createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = createWinningLotto(); // 당첨 로또 생성
        printWinningStatisticsResult(userLotto, winningLotto); // 당첨 통계 출력
    }

    // 사용자 로또 생성
    private List<Lotto> createUserLotto() {
        return getRandomLottoNumber(getPurchaseAmount());
    }

    // 구매한 로또 갯수만큼 사용자 총 로또 리스트 반환
    public List<Lotto> getRandomLottoNumber(int amount) {
        List<Lotto> userLotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = Lotto.getRandomNumber();
            Lotto lotto = new Lotto(lottoNumber);
            userLotto.add(lotto);
        }

        printUserLottoNumber(userLotto);

        return userLotto;
    }

    // 사용자 총 로또 리스트 출력
    private void printUserLottoNumber(List<Lotto> userLotto) {
        for (Lotto lotto : userLotto) {
            List<Integer> lottoNumber = lotto.getNumber();

            OutputView.printLottoNumber(lottoNumber);
        }

        System.out.println("");
    }

    // 구매 갯수 반환
    private int getPurchaseAmount() {
        int cost = inputCost();
        int amount = calculateCount(cost); // 구매 갯수 계산

        OutputView.printPurchaseAmountMessage(amount); // 구매 갯수 메세지 출력

        return amount;
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

    // 당첨 로또 생성
    private WinningLotto createWinningLotto() {
        String[] winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();

        List<Integer> winningNumbers = new ArrayList(Arrays.asList(winningNumber)); // List로 변환
        Lotto lotto = new Lotto(winningNumbers); // 로또 티켓 생성

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    // 지난 주 당첨 번호 입력
    private String[] inputWinningNumber() {
        String[] winningNumber = new String[6];

        do {
            String lottoNumber = InputView.inputWinningNumber(); // 지난주 당첨번호 입력
            winningNumber = splitLastWeekNumber(lottoNumber); // 당첨번호 , 기준으로 split
        }
        while (!(isValidateWinningNumberLength(winningNumber)));

        return winningNumber;
    }

    // 지난 주 당첨번호 String > String[] 스플릿
    public String[] splitLastWeekNumber(String number) {
        return number.split(",");
    }

    // 지난 주 보너스 번호 입력
    private int inputBonusNumber() {
        int bonusNumber = LOTTO_MIN_RANDOM_NUMBER;

        do {
            bonusNumber = InputView.inputBonusNumber();
            System.out.println("");
        } while (!(isValidateBonusNumber(bonusNumber)));

        return bonusNumber;
    }

    // 당첨 통계 출력
    private void printWinningStatisticsResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        HashMap<Rank, Integer> statistics = initHashMap();

        checkMatch(userLotto, winningLotto, statistics);

        int winningMoney = getTotalWinningMoney(statistics);
        double yield = getTotalYield(winningMoney, userLotto);

        OutputView.printWinningStatisticsResult(statistics);
        OutputView.printTotalYield(yield);
    }

    // HashMap 초기화
    private HashMap<Rank, Integer> initHashMap() {
        HashMap<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);

        return lottoResult;
    }

    // 하나의 로또 매치 시켜가면서 당첨 통계를 구한다
    private void checkMatch(List<Lotto> userLotto, WinningLotto winningLotto, HashMap<Rank, Integer> statistics) {
        for (Lotto lotto : userLotto) {
            Rank rank = winningLotto.match(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    private int getTotalWinningMoney(HashMap<Rank, Integer> statistics) {
        int totalWinningMoney = 0;

        for (Rank rank : Rank.values()) {
            int winningMoney = rank.getWinningMoney();
            int amount = statistics.get(rank);

            totalWinningMoney += winningMoney * amount;
        }

        return totalWinningMoney;
    }

    // 총 수익률
    private double getTotalYield(double winningMoney, List<Lotto> userLotto) {
        double amountPaid = (userLotto.size() * LOTTO_TICKET_PRICE);
        double yield = winningMoney / amountPaid;

        return yield;
    }
}
