package domain;

import java.util.*;

public class GameHelper {
    private static final int LOTTO_PRICE_PER_ONE = 1000;
    private static final int LOTTO_NUM_PER_ONE_LINE = 6;

    public static List<Lotto> createLottoes(int lottoCount) {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createOneLotto();
            lottoes.add(lotto);
        }

        return lottoes;
    }

    // 로또 금액 받아서 몇개 산 건지 계산
    public static int getLottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE_PER_ONE;
    }

    // 랜덤 숫자로 이루어진 하나의 로또 객체 생성하기.
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

    // 입력한 지난번 당첨 로또 번호 split -> List에 담아서 리턴
    private static Set<Integer> splitWinnigLottoNumber(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        Set<Integer> winningLottoNumber = new HashSet<>();

        for (String number : splitNumbers) {
            winningLottoNumber.add(Integer.parseInt(number));
        }

        return winningLottoNumber;
    }

    public static Map<Rank, Integer> getLottoWinResult(WinningLotto winningLotto, List<Lotto> lottoes) {
        // 맞은 로또 결과 저장할 Map 초기화
        Map<Rank, Integer> lottoResult = createResult();

        for(Lotto lotto : lottoes) {
            // 로또 하나 당 당첨 로또랑 비교해서 몇 개 맞았는 지 랭크 확인
            Rank rank = winningLotto.match(lotto);

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }

        return lottoResult;
    }

    // 맞은 로또 결과 저장할 Map 초기화
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

    // 구한 당첨결과 맵을 이용해서 총 상금 구하는 메서드
    public static int getLottoTotalMoney(Map<Rank, Integer> lottoWinResult) {
        int totalWinMoney = 0;

        for(Rank rank : lottoWinResult.keySet()) {
            // 따낸 로또 랭크가 있다면 totalWinMoney에 더하기
            if(lottoWinResult.get(rank) > 0) {
                totalWinMoney += rank.getWinningMoney();
            }
        }

        return totalWinMoney;
    }

}
