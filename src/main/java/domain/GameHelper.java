package domain;

import java.util.*;

public class GameHelper {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    public void createLottoes(List<Lotto> lottoes, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createOneLotto();
            lottoes.add(lotto);
        }
    }

    // 로또 금액 받아서 몇개 산 건지 계산
    public int getLottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE_PER_ONE;
    }

    // 랜덤 숫자로 이루어진 하나의 로또 객체 생성하기.
    public Lotto createOneLotto() {
        List<Integer> lottoNums = CreateLottoNumber.createLottosNumber();
        return new Lotto(lottoNums);
    }

    public WinningLotto createWinningLotto(String winningNumbers, int bonusNumber) {
        Set<Integer> splitNumbers = splitWinnigLottoNumber(winningNumbers);
        List<Integer> winningLottoNumber = new ArrayList<>(splitNumbers);

        Lotto lotto = new Lotto(winningLottoNumber);

        return new WinningLotto(lotto, bonusNumber);
    }

    public boolean checkDuplicatedNumber(String winningNumbers) {
        Set<Integer> splitWinningNumbers = splitWinnigLottoNumber(winningNumbers);
        return splitWinningNumbers.size() == 6;
    }

    // 입력한 지난번 당첨 로또 번호 split -> List에 담아서 리턴
    private Set<Integer> splitWinnigLottoNumber(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        Set<Integer> winningLottoNumber = new HashSet<>();

        for (String number : splitNumbers) {
            winningLottoNumber.add(Integer.parseInt(number));
        }

        return winningLottoNumber;
    }

    public List<Integer> getLottoResult(WinningLotto winningLotto, List<Lotto> lottoes) {
        Map<Rank, Integer> lottoResult = checkLottoWinCount(winningLotto, lottoes);

        return getLottoWinResult(lottoResult);
    }

    private Map<Rank, Integer> checkLottoWinCount(WinningLotto winningLotto, List<Lotto> lottoes) {
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
    private Map<Rank, Integer> createResult(){
        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.MISS, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);

        return lottoResult;
    }

    public int getLottoTotalMoney(WinningLotto winningLotto, List<Lotto> lottoes) {
        int totalWinMoney = 0;

        for(Lotto lotto : lottoes) {
            // 로또 하나 당 당첨 로또랑 비교해서 몇 개 맞았는 지 랭크 확인
            Rank rank = winningLotto.match(lotto);
            totalWinMoney += rank.getWinningMoney();
        }

        return totalWinMoney;
    }

    public List<Integer> getLottoWinResult(Map<Rank, Integer> lottoResult) {
        List<Integer> lottoWinResult = new ArrayList<>();

        lottoWinResult.add(lottoResult.get(Rank.FIFTH));
        lottoWinResult.add(lottoResult.get(Rank.FOURTH));
        lottoWinResult.add(lottoResult.get(Rank.THIRD));
        lottoWinResult.add(lottoResult.get(Rank.SECOND));
        lottoWinResult.add(lottoResult.get(Rank.FIRST));

        return lottoWinResult;
    }

    public double getYield(int totalGetMoney, int lottoPrice) {
        return (double)totalGetMoney / lottoPrice;
    }

}
