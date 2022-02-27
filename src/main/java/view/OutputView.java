package view;

import model.Rank;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String PURCHASE_INFORMATION_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_INFORMATION_MESSAGE = "당첨 통계\n--------------";
    private static final String FIFTH_RANK_GUIDE_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOURTH_RANK_GUIDE_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String THREE_RANK_GUIDE_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_RANK_GUIDE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_RANK_GUIDE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String LOTTO_UNIT = "개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 ";
    private static final String PREPOSITIONAL_PARTICLE_FOR_VERB_MESSAGE = " 입니다.";

    public static void printPurchaseAmountMessage(int amount) {
        System.out.println(amount + PURCHASE_INFORMATION_MESSAGE);
    }

    public static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void printWinningStatisticsResult(HashMap winningStatistics) {
        System.out.println(WINNING_STATISTICS_INFORMATION_MESSAGE);
        System.out.println(FIFTH_RANK_GUIDE_MESSAGE + winningStatistics.get(Rank.FIFTH) + LOTTO_UNIT);
        System.out.println(FOURTH_RANK_GUIDE_MESSAGE + winningStatistics.get(Rank.FOURTH) + LOTTO_UNIT);
        System.out.println(THREE_RANK_GUIDE_MESSAGE + winningStatistics.get(Rank.THIRD) + LOTTO_UNIT);
        System.out.println(SECOND_RANK_GUIDE_MESSAGE + winningStatistics.get(Rank.SECOND) + LOTTO_UNIT);
        System.out.println(FIRST_RANK_GUIDE_MESSAGE + winningStatistics.get(Rank.FIRST) + LOTTO_UNIT);
    }

    public static void printTotalYield(double yield) {
        DecimalFormat form = new DecimalFormat("#,##0.00");

        System.out.println(TOTAL_YIELD_MESSAGE + form.format(yield) + PREPOSITIONAL_PARTICLE_FOR_VERB_MESSAGE);
    }
}
