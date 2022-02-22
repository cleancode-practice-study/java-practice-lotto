package view;

import domain.Lotto;

public class OutputView {
    private static final String LOTTO_PUCHASE_COUNT_OUTPUT_MESSAGE = "%s개를 구매했습니다.";

    public static void printLottoCount(int lottoCount) {
        System.out.printf(LOTTO_PUCHASE_COUNT_OUTPUT_MESSAGE, lottoCount);
        System.out.println();
    }

    public static void printLottoNumber(Lotto lotto) {
        lotto.printLottoNum();
    }
}
