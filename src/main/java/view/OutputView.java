package view;

import domain.Lotto;
import domain.Lottoes;
import domain.Rank;

import java.util.Map;

public class OutputView {
    private static final String LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE = "%s개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.";
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

    public static void printInvalidLottoNumberError() {
        System.out.println(WINNING_LOTTO_NUMBER_ERROR_MESSAGE);
    }

    public static void printLottoNumber(Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getLottoNum());
        }
    }

    public static void printLottoResult(Map<Rank, Integer> lottoWinResult) {
        System.out.println();
        System.out.println(LOTTO_RESULT_OUTPUT_MESSAGE);
        System.out.printf(LOTTO_FIFTH_OUTPUT_MESSAGE, lottoWinResult.get(Rank.FIFTH));
        System.out.printf(LOTTO_FOURTH_OUTPUT_MESSAGE, lottoWinResult.get(Rank.FOURTH));
        System.out.printf(LOTTO_THIRD_OUTPUT_MESSAGE, lottoWinResult.get(Rank.THIRD));
        System.out.printf(LOTTO_SECOND_OUTPUT_MESSAGE, lottoWinResult.get(Rank.SECOND));
        System.out.printf(LOTTO_FIRST_OUTPUT_MESSAGE, lottoWinResult.get(Rank.FIRST));
    }

    public static void printLottoYield(double yield) {
        System.out.printf(LOTTO_YIELD_OUTPUT_MESSAGE, yield);
    }

    public static void printNextLine() {
        System.out.println();
    }
}
