package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static controller.LottoGameController.printTotalYield;
import static controller.LottoGameController.printWinningStatistics;

public class Statistics {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 당첨 통계 구하기
    public static Map<Rank, Integer> getWinningStatistics(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = initStatistics();
        registerMatchStatistics(userLotto, winningLotto, statistics);

        return statistics;
    }

    // 총 수익률 반환
    public static double getTotalYield(double winningMoney, int amount) {
        double amountPaid = (amount * LOTTO_TICKET_PRICE);

        return winningMoney / amountPaid;
    }

    // 로또 게임 결과 출력
    public static void printLottoGameResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        printWinningStatistics(userLotto, winningLotto);
        Map<Rank, Integer> statistics = getWinningStatistics(userLotto, winningLotto);
        int winningMoney = getTotalWinningMoney(statistics);
        printTotalYield(userLotto, winningMoney);
    }

    // 통계 초기화
    private static Map<Rank, Integer> initStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        return statistics;
    }

    // 매치 통계 결과 등록
    private static void registerMatchStatistics(List<Lotto> userLotto, WinningLotto winningLotto, Map<Rank, Integer> statistics) {
        for (Lotto lotto : userLotto) {
            Rank rank = winningLotto.match(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    // 총 당첨 금액 반환
    private static int getTotalWinningMoney(Map<Rank, Integer> statistics) {
        int totalWinningMoney = 0;

        for (Rank rank : Rank.values()) {
            int winningMoney = rank.getWinningMoney();
            int amount = statistics.get(rank);

            totalWinningMoney += winningMoney * amount;
        }

        return totalWinningMoney;
    }
}