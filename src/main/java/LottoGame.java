import java.awt.*;
import java.util.*;
import java.util.List;

public class LottoGame {
    static private final int LOTTO_NUM_PER_ONE_LINE = 6;
    static private final int LOTTO_NUM_START_INCLUSIVE = 1;
    static private final int LOTTO_TOTAL_NUM = 45;
    static private final int NUM_TO_DEVIDE_LOTTO_PRICE = 1000;

    final Scanner scanner = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public void gameStart() {
        List<Lotto> lottos  = create();
        showPurchaseLotto(lottos);
        List<Integer> winningLottoNums = intArrayToIntegerList();
        createWinningLotto(winningLottoNums);
    }

    private List<Lotto> create() {
        int lottoNum = getLottoByUserInput();

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoNum ; i++) {
            lottos.add(createEachLotto());
        }

        System.out.println(lottoNum + "개를 구입했습니다.");

        return lottos;
    }

    private Lotto createEachLotto() {
        Set<Integer> lottoNumsForDeduplication = new HashSet<>();

        for(int i = 0; i < LOTTO_NUM_PER_ONE_LINE ; i++) {
            lottoNumsForDeduplication.add(RANDOM.nextInt(LOTTO_TOTAL_NUM) + LOTTO_NUM_START_INCLUSIVE);
        }

        List<Integer> lottoNums = new ArrayList<>(lottoNumsForDeduplication);
        Lotto oneLotto = new Lotto(lottoNums);

        return oneLotto;
    }

    private int getLottoByUserInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int userInputPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        userInputPrice = userInputPrice/NUM_TO_DEVIDE_LOTTO_PRICE;

        return userInputPrice;
    }

    private void showPurchaseLotto(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            lotto.printLottoNums();
        }
        System.out.println();
    }

    private List<Integer> intArrayToIntegerList () {
        int[] winningLottoNum = StringToIntArray();

        List<Integer> winningNumForCreatingLotto = new ArrayList<>();

        for(int num : winningLottoNum) {
            winningNumForCreatingLotto.add(num);
        }

        return winningNumForCreatingLotto;
    }

    private int[] StringToIntArray () {
        String[] winningNum = getWinningLottoNumByUserInput();

        int[] winningLottoNum = Arrays.stream(winningNum).mapToInt(Integer::parseInt).toArray();

        return winningLottoNum;
    }

    private String[] getWinningLottoNumByUserInput () {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");

        String winningLottoNum = scanner.nextLine();
        String[] winningNum = splitNum(winningLottoNum);

        return winningNum;
    }

    private String[] splitNum (String winningLottoNum) {
        String[] winningNum = winningLottoNum.split(",");

        return winningNum;
    }


    private WinningLotto createWinningLotto (List<Integer> winningLottoNum) {
        int bonusBall = getBonusNumByUserInput();

        Lotto lotto = new Lotto(winningLottoNum);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

        return winningLotto;
    }

    private int getBonusNumByUserInput() {
        System.out.println("보너스 볼을 입력해주세요.");

        int bonusBall = scanner.nextInt();

        return bonusBall;
    }



}
