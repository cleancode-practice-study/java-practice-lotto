package controller;

import model.Lotto;
import model.Rank;
import model.Statistics;
import model.WinningLotto;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {
    // 사용자 로또 생성
    private static List<Lotto> createUserLotto() {
        int cost = InputController.getCost(); // view 호출, 사용자 로또 구입 금액 구하기
        int count = Lotto.getCount(cost); // model 호출, 사용자 로또 구입 갯수 구하기
        OutputView.printPurchaseMessage(count); // view 호출, 사용자 로또 구입 갯수 안내 메세지 출력

        List<Lotto> userLotto = Lotto.getUserLotto(count); // model 호출, 사용자 구입 로또 리스트 구하기
        OutputView.printUserLotto(userLotto); // view 호출, 사용자 구입 로또 리스트 출력

        return userLotto;
    }

    // 당첨 로또 생성
    private static WinningLotto createWinningLotto() {
        String[] winningNumber = InputController.getWinningNumber(); // view 호출, 지난주 당첨 번호 구하기
        int bonusNumber = InputController.getBonusNumber(); // view 호출, 지난주 보너스 번호 구하기

        List<Integer> winningNumbers = Lotto.changeStringArrayToList(winningNumber); // model 호출, string[] > list<Integer>
        Lotto lotto = Lotto.getLotto(winningNumbers); // model 호출, 당첨 로또 생성

        return new WinningLotto(lotto, bonusNumber);
    }

    // 로또 게임 결과 출력
    private static void printLottoGameResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = Statistics.getWinningStatistics(userLotto, winningLotto); // model 호출, 당첨 통계 구하기
        OutputView.printWinningStatistics(statistics); // view 호출, 당첨 통계 출력

        int winningMoney = Statistics.getTotalWinningMoney(statistics); // model 호출, 당첨 금액 구하기
        double yield = Statistics.getTotalYield(winningMoney, userLotto.size()); // model 호출, 총 수익률 구하기
        OutputView.printTotalYield(yield); // view 호출, 총 수익률 출력
    }

    public void play() {
        List<Lotto> userLotto = createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = createWinningLotto(); // 당첨 로또 생성
        printLottoGameResult(userLotto, winningLotto); // 로또 게임 결과 출력
    }
}
