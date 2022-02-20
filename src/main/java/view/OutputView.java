package view;

import java.util.List;

public class OutputView {
    private static final int LOTTO_TICKET_LENGTH = 6;

    public static void printLottoAmount(int amount){
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<String> lottoNumber){
            System.out.println(lottoNumber);
    }

    public static void printWinningResult(){
        System.out.println("당첨 통계\n--------------");
    }

    public static void printYield(int yield){
        System.out.println("총 수익률은" + yield + "입니다.");
    }
}
