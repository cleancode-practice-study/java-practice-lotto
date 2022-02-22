package view;

public class OutputView {
    private static final String LOTTO_PUCHASE_COUNT_OUTPUT_MESSAGE = "%s개 구매했습니다.";

    public static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_PUCHASE_COUNT_OUTPUT_MESSAGE, lottoCount);
    }
}
