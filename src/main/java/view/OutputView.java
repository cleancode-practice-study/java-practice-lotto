package view;

import domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE = "%s개를 구매했습니다.";
    private static final String LOTTO_RESULT_OUTPUT_MESSAGE = "당첨 통계\n----------------";
    private static final String LOTTO_FIFTH_OUTPUT_MESSAGE = "3개 일치 (5000원) - %d개\n";
    private static final String LOTTO_FOURTH_OUTPUT_MESSAGE = "4개 일치 (50000원) - %d개\n";
    private static final String LOTTO_THIRD_OUTPUT_MESSAGE = "5개 일치 (1500000원) - %d개\n";
    private static final String LOTTO_SECOND_OUTPUT_MESSAGE = "5개 일치, 보너스 볼 일치 (30000000원) - %d개\n";
    private static final String LOTTO_FIRST_OUTPUT_MESSAGE = "6개 일치 (2000000000)원 - %d개\n";
    private static final String LOTTO_YIELD_OUTPUT_MESSAGE = "총 수익률은 %.2f입니다.\n";

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf(LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE, lottoCount);
        System.out.println();
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNum());
    }

    public static void printLottoResult(List<Integer> winningResult) {
        System.out.println();
        System.out.println(LOTTO_RESULT_OUTPUT_MESSAGE);
        System.out.printf(LOTTO_FIFTH_OUTPUT_MESSAGE, winningResult.get(0));
        System.out.printf(LOTTO_FOURTH_OUTPUT_MESSAGE, winningResult.get(1));
        System.out.printf(LOTTO_THIRD_OUTPUT_MESSAGE, winningResult.get(2));
        System.out.printf(LOTTO_SECOND_OUTPUT_MESSAGE, winningResult.get(3));
        System.out.printf(LOTTO_FIRST_OUTPUT_MESSAGE, winningResult.get(4));
    }

    public static void pringLottoYield(double yield) {
        System.out.printf(LOTTO_YIELD_OUTPUT_MESSAGE, yield);
    }

    public static void printNextLine() {
        System.out.println();
    }
}
