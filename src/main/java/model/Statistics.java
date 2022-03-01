package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static controller.LottoGameController.printTotalYield;
import static controller.LottoGameController.printWinningStatistics;

public class Statistics {
    private static final int LOTTO_TICKET_PRICE = 1000;

    // 통계 초기화
    public static Map<Rank, Integer> initStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        return statistics;
    }

    // 매치 통계 등록
    public static void registerMatchStatistics(List<Lotto> userLotto, WinningLotto winningLotto, Map<Rank, Integer> statistics) {
        for (Lotto lotto : userLotto) {
            Rank rank = winningLotto.match(lotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    // 당첨 통계 구하기
    public static Map getWinningStatistics(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = initStatistics();
        Statistics.registerMatchStatistics(userLotto, winningLotto, statistics);

        return statistics;
    }

    public static int getWinningMoney(Map<Rank, Integer> statistics) {
        int winningMoney = Statistics.getTotalWinningMoney(statistics);

        return winningMoney;
    }

    // 총 당첨금액
    public static int getTotalWinningMoney(Map<Rank, Integer> statistics) {
        int totalWinningMoney = 0;

        for (Rank rank : Rank.values()) {
            int winningMoney = rank.getWinningMoney();
            int amount = statistics.get(rank);

            totalWinningMoney += winningMoney * amount;
        }

        return totalWinningMoney;
    }

    // 총 수익률
    public static double getTotalYield(double winningMoney, int amount) {
        double amountPaid = (amount * LOTTO_TICKET_PRICE);
        double yield = winningMoney / amountPaid;

        return yield;
    }

    // 로또 게임 결과 출력
    public static void printLottoGameResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        printWinningStatistics(userLotto, winningLotto);
        Map statistics = getWinningStatistics(userLotto, winningLotto);
        int winningMoney = getWinningMoney(statistics);
        printTotalYield(userLotto, winningMoney);
    }
}