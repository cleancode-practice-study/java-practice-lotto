package view;

import java.util.Scanner;

public class InputView {
    private static final String LOTTO_PUCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 올바른 로또 금액으로 입력해주세요. (1000원 단위)";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputLottoPurchasePrice () {
        System.out.println(LOTTO_PUCHASE_PRICE_INPUT_MESSAGE);
        int lottoPrice = getLottoPrice();
        checkValidLottoPrice(lottoPrice);
        return lottoPrice;
    }

    private static int getLottoPrice() {
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
}
