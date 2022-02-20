package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final int LOTTO_TICKET_PRICE = 1000;

    public static int inputLottoAmount(){
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        int cost = scanner.nextInt();
        return calculateLottoAmount(cost);
    }

    public static int calculateLottoAmount(int cost){
        int amount = cost / LOTTO_TICKET_PRICE;
        return amount;
    }

    public static String inputLastWeekWinningNumber(){
        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        return scanner.next();
    }

    public static int inputBonusBallNumber(){
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
