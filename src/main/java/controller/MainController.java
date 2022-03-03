package controller;

import model.*;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class MainController {
    public void play() {
        List<Lotto> userLotto = createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = createWinningLotto(); // 당첨 로또 생성
        printLottoGameResult(userLotto, winningLotto); // 로또 게임 결과 출력
    }

    // 사용자 로또 생성
    private List<Lotto> createUserLotto() {
        int cost = InputController.inputCost(); // view 호출, 사용자 로또 구입 금액 입력
        int count = User.getCount(cost); // model 호출, 사용자 로또 구입 갯수 구하기
        OutputView.printPurchaseMessage(count); // view 호출, 사용자 로또 구입 갯수 안내 메세지 출력

        List<Lotto> userLotto = User.getTotalLotto(count); // model 호출, 사용자 구입 로또 리스트 구하기
        OutputView.printUserLotto(userLotto); // view 호출, 사용자 구입 로또 리스트 출력

        return userLotto;
    }

    // 당첨 로또 생성
    private WinningLotto createWinningLotto() {
        String[] winningNumber = InputController.inputWinningNumber(); // view 호출, 지난주 당첨 번호 입력
        int bonusNumber = InputController.inputBonusNumber(); // view 호출, 지난주 보너스 번호 입력

        List<Integer> winningNumbers = Lotto.changeStringArrayToList(winningNumber); // model 호출, string[] > list<Integer>
        Lotto lotto = Lotto.getLotto(winningNumbers); // model 호출, 당첨 로또 생성

        return new WinningLotto(lotto, bonusNumber);
    }

    // 로또 게임 결과 출력
    private void printLottoGameResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = Statistics.getWinningStatistics(userLotto, winningLotto); // model 호출, 당첨 통계 구하기
        OutputView.printWinningStatistics(statistics); // view 호출, 당첨 통계 출력

        int winningMoney = Statistics.getTotalWinningMoney(statistics); // model 호출, 당첨 금액 구하기
        double yield = Statistics.getTotalYield(winningMoney, userLotto.size()); // model 호출, 총 수익률 구하기
        OutputView.printTotalYield(yield); // view 호출, 총 수익률 출력
    }
}
