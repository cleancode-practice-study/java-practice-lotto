import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayLottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_COUNT = 6;

    public void start() {
        getLotto();
        getWinningNumber();

        System.out.println("당첨 통계");
        System.out.println("--------------");
        getStatistics();
        printStatistics();
    }

    private int getMoney(){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        System.out.println();

        return money;
    }

    private List<Lotto> getLotto() {
        List<Lotto> userLotto = new ArrayList<>();
        int money = getMoney();

        System.out.println(money / LOTTO_PRICE + "개를 구매했습니다.");
        for(int i = 0; i < money / LOTTO_PRICE; i++){
            Lotto lotto = new Lotto(getLottoNumber());
            userLotto.add(lotto);
            userLotto.get(i).printLottoNumber();
        }
        System.out.println("");

        return userLotto;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < MAX_LOTTO_COUNT; i++){
            lottoNumbers.add(random.nextInt(45) + 1);
        }

        return lottoNumbers;
    }

    private void getWinningNumber() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
    }

    private void getStatistics() {

    }

    private void printStatistics() {
        double rateOfReturn = (double) winningMoney / (double) getMoney();
        System.out.println("3개 일치 (5000원)- " +  + "개");
        System.out.println("4개 일치 (50000원)- " +  + "개");
        System.out.println("5개 일치 (1500000원)- " +  + "개");
        System.out.println("5개 일치,보너스 볼 일치 (30000000원)- " +  + "개");
        System.out.println("6개 일치 (2000000000원)- " +  + "개");
        System.out.println("총 수익률은 " + + "입니다.");

    }





}
