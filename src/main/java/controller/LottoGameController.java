package controller;

import model.Lotto;
import model.Rank;
import model.Statistics;
import model.WinningLotto;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static model.Statistics.initStatistics;
import static model.User.getLottoCount;
import static model.User.getRandomLotto;

public class LottoGameController {
    public void play() {
        List<Lotto> userLotto = createUserLotto(); // 사용자 로또 생성
        WinningLotto winningLotto = WinningLotto.createWinningLotto(); // 당첨 로또 생성
        printWinningStatisticsResult(userLotto, winningLotto); // 당첨 통계 출력
    }

    // 사용자 로또 생성: 안내 문구 & 구매 결과 출력
    private static List<Lotto> createUserLotto() {
        List<Lotto> userLotto = new ArrayList<>();
        int count = getLottoCount();

        OutputView.printPurchaseAmountMessage(count); // 구매 갯수 메세지 출력

        for (int i = 0; i < count; i++) {
            Lotto lotto = getRandomLotto();
            userLotto.add(lotto);
        }

        OutputView.printUserLotto(userLotto); // 사용자가 구매한 로또 번호 출력

        return userLotto;
    }

    // 당첨 통계 결과 출력
    private void printWinningStatisticsResult(List<Lotto> userLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = initStatistics();

        Statistics.registerMatchStatistics(userLotto, winningLotto, statistics);

        int winningMoney = Statistics.getTotalWinningMoney(statistics);
        int count = userLotto.size();
        double yield = Statistics.getTotalYield(winningMoney, count);

        OutputView.printWinningStatisticsResult(statistics);
        OutputView.printTotalYield(yield);
    }
}