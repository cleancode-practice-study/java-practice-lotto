package model;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private static final int LOTTO_TICKET_PRICE = 1000;

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

    // HashMap 초기화
    public static Map<Rank, Integer> initStatistics() {
        Map<Rank, Integer> statistics = new HashMap<>();

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        return statistics;
    }
}