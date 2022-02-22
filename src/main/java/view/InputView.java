package view;

import java.util.Scanner;

public class InputView {
    private static final String LOTTO_PUCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 올바른 로또 금액으로 입력해 주세요. (1000원 단위)";
    private static final String WINNING_LOTTO_NUMBER_INPUT_MESSAGE = "지난 주 당첨번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_BONUS_INPUT_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String WINNING_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputLottoPurchasePrice () {
        System.out.println(LOTTO_PUCHASE_PRICE_INPUT_MESSAGE);
        int lottoPrice = getInt();
        checkValidLottoPrice(lottoPrice);
        return lottoPrice;
    }

    private static int getInt() {
        try {
            return scanner.nextInt();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkValidLottoPrice(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    public static String inputWinningLottoNumber () {
        System.out.println(WINNING_LOTTO_NUMBER_INPUT_MESSAGE);
        return scanner.next();
    }

    public static int inputWinningBonusNumber() {
        System.out.println(WINNING_LOTTO_BONUS_INPUT_MESSAGE);
        return getInt();
    }

    public static void checkValidWinningLottoNumber(boolean isValid) {
        if (!isValid) {
            System.out.println(WINNING_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

}
