package controller;

import domain.CreateLottoNumber;
import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.*;


public class Controller {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    public void run() {
        List<Lotto> lottoes = createLottoes();
        WinningLotto winningLotto = createWinningLotto();
        printResult(winningLotto, lottoes);
    }

    // 랜덤 로또 생성
    private List<Lotto> createLottoes() {
        // 얼마 어치의 로또를 구매할 건지 입력
        int lottoPrice = InputView.inputLottoPurchasePrice();
        int lottoCount = getLottoCount(lottoPrice);

        // 몇 개의 로또를 구매했는 지 출력
        System.out.println();
        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createOneLotto();
            lottoes.add(lotto);
        }

        printLottoNumber(lottoes);

        return lottoes;
    }

    // 로또 금액 받아서 몇개 산 건지 계산
    private int getLottoCount(int lottoPrice) {
        return lottoPrice / LOTTO_PRICE_PER_ONE;
    }

    // 랜덤 숫자로 이루어진 하나의 로또 객체 생성하기.
    private Lotto createOneLotto() {
        List<Integer> lottoNums = CreateLottoNumber.createLottosNumber();
        return new Lotto(lottoNums);
    }

    // 구매한 로또 번호 출력
    private void printLottoNumber(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            OutputView.printLottoNumber(lotto);
        }
        System.out.println();
    }

    // 당첨 로또 객체 생성
    private WinningLotto createWinningLotto() {
        boolean isValid = false;
        Set<Integer> winningNumberForCheck = null;

        // 당첨 번호 입력을 중복으로 했을 경우 다시 입력 받도록 함.
        while (!isValid) {
            // 당첨 로또 번호 받기
            String winningNum = InputView.inputWinningLottoNumber();

            winningNumberForCheck = splitWinnigLottoNumber(winningNum);

            isValid = checkDuplicatedNumber(winningNumberForCheck);

            InputView.checkValidWinningLottoNumber(isValid);
        }

        // 당첨 로또 보너스 받기
        int bonusNum = InputView.inputWinningBonusNumber();

        List<Integer> winningLottoNumber = new ArrayList<>(winningNumberForCheck);

        Lotto lotto = new Lotto(winningLottoNumber);

        return new WinningLotto(lotto, bonusNum);
    }

    // 입력한 지난번 당첨 로또 번호 split -> List에 담아서 리턴
    private Set<Integer> splitWinnigLottoNumber(String winningNumber) {
        String[] splitNumbers = winningNumber.split(",");
        Set<Integer> winningLottoNumber = new HashSet<>();

        for (String number : splitNumbers) {
            winningLottoNumber.add(Integer.parseInt(number));
        }

        return winningLottoNumber;
    }

    private boolean checkDuplicatedNumber(Set<Integer> winningNumber) {
        return winningNumber.size() == 6;
    }

    private void printResult(WinningLotto winningLotto, List<Lotto> lottoes) {
        // 맞은 로또 결과 저장할 Map 초기화
        Map<Rank, Integer> lottoResult = createResult();

        // 당첨 금액 구하기
        int totalGetMoney = checkLottoWinCount(winningLotto, lottoes, lottoResult);

        // 당첨 결과 리스트로 받기 순서대로 [3개 일치, 4개일치, 5개 일치, 5개 + 보너스 일치, 6개 일치 개수]
        List<Integer> winningResult = getLottoWinResult(lottoResult);

        // 당첨 금액과 구매 금액으로 수익률 구하기
        double yield = getYield(totalGetMoney, lottoes.size() * LOTTO_PRICE_PER_ONE);

        // 당첨 통계 출력
        OutputView.printLottoResult(winningResult);
        OutputView.pringLottoYield(yield);
    }

    // 맞은 로또 결과 저장할 Map 초기화
    private  Map<Rank, Integer> createResult(){
        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.MISS, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);

        return lottoResult;
    }

    private int checkLottoWinCount(WinningLotto winningLotto, List<Lotto> lottoes, Map<Rank, Integer> lottoResult) {
        int totalWinMoney = 0;

        for(Lotto lotto : lottoes) {
            // 로또 하나 당 당첨 로또랑 비교해서 몇 개 맞았는 지 랭크 확인
            Rank rank = winningLotto.match(lotto);

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);

            totalWinMoney += rank.getWinningMoney();
        }

        return totalWinMoney;
    }

    private List<Integer> getLottoWinResult(Map<Rank, Integer> lottoResult) {
        List<Integer> lottoWinResult = new ArrayList<>();

        lottoWinResult.add(lottoResult.get(Rank.FIFTH));
        lottoWinResult.add(lottoResult.get(Rank.FOURTH));
        lottoWinResult.add(lottoResult.get(Rank.THIRD));
        lottoWinResult.add(lottoResult.get(Rank.SECOND));
        lottoWinResult.add(lottoResult.get(Rank.FIRST));

        return lottoWinResult;
    }

    private double getYield(int totalGetMoney, int lottoPrice) {
        return (double)totalGetMoney / lottoPrice;
    }

}
