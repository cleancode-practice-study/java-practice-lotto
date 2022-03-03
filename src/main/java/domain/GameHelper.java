package domain;

import java.util.*;

public class GameHelper {
    private static final int LOTTO_PRICE_PER_ONE = 1000;
    private static final int LOTTO_NUM_PER_ONE_LINE = 6;

    public static int getLottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE_PER_ONE;
    }

    public static Lottoes createLottoes(int lottoCount) {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createOneLotto();
            lottoes.add(lotto);
        }

        return new Lottoes(lottoes);
    }

    private static Lotto createOneLotto() {
        List<Integer> lottoNums = LottoNumberCreator.createLottosNumber();
        return new Lotto(lottoNums);
    }

    public static WinningLotto createWinningLotto(String winningNumbers, int bonusNumber) {
        Set<Integer> splitNumbers = splitWinnigLottoNumber(winningNumbers);
        List<Integer> winningLottoNumber = new ArrayList<>(splitNumbers);

        Lotto lotto = new Lotto(winningLottoNumber);

        return new WinningLotto(lotto, bonusNumber);
    }

    public static boolean checkDuplicatedNumber(String winningNumbers) {
        Set<Integer> splitWinningNumbers = splitWinnigLottoNumber(winningNumbers);
        return splitWinningNumbers.size() == LOTTO_NUM_PER_ONE_LINE;
    }

    private static Set<Integer> splitWinnigLottoNumber(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        Set<Integer> winningLottoNumber = new HashSet<>();

        for (String number : splitNumbers) {
            winningLottoNumber.add(Integer.parseInt(number));
        }

        return winningLottoNumber;
    }

    public static Map<Rank, Integer> getLottoWinResult(WinningLotto winningLotto, Lottoes lottoes) {
        Map<Rank, Integer> lottoResult = createResult();

        lottoResult = lottoes.getLottoWinResult(lottoResult, winningLotto);

        return lottoResult;
    }

    private static Map<Rank, Integer> createResult(){
        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.MISS, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);

        return lottoResult;
    }

    public static double getYield(Map<Rank, Integer> lottoWinResult, int lottoPrice) {
        int totalGetMoney = getLottoTotalMoney(lottoWinResult);

        return (double)totalGetMoney / lottoPrice;
    }

    private static int getLottoTotalMoney(Map<Rank, Integer> lottoWinResult) {
        int totalWinMoney = 0;

        for(Rank rank : lottoWinResult.keySet()) {
            if(lottoWinResult.get(rank) > 0) {
                totalWinMoney += rank.getWinningMoney();
            }
        }

        return totalWinMoney;
    }

}
