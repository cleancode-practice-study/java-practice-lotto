package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.Rank.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {
    @Test
    void 당첨_통계를_구하는_경우() {
        //given
        List<Integer> firstLotto = new ArrayList<>();
        firstLotto.add(1);
        firstLotto.add(2);
        firstLotto.add(3);
        firstLotto.add(4);
        firstLotto.add(5);
        firstLotto.add(6);

        List<Integer> secondLotto = new ArrayList<>();
        secondLotto.add(10);
        secondLotto.add(15);
        secondLotto.add(22);
        secondLotto.add(33);
        secondLotto.add(40);
        secondLotto.add(41);

        List<Integer> thirdLotto = new ArrayList<>();
        thirdLotto.add(8);
        thirdLotto.add(11);
        thirdLotto.add(14);
        thirdLotto.add(31);
        thirdLotto.add(38);
        thirdLotto.add(44);

        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(10);
        winningNumber.add(11);
        winningNumber.add(14);
        winningNumber.add(31);
        winningNumber.add(40);
        winningNumber.add(41);

        int bonusNumber = 8;

        Lotto first = new Lotto(firstLotto);
        Lotto second = new Lotto(secondLotto);
        Lotto third = new Lotto(thirdLotto);
        Lotto winning = new Lotto(winningNumber);

        List<Lotto> userLotto = new ArrayList<>();
        userLotto.add(first);
        userLotto.add(second);
        userLotto.add(third);

        WinningLotto winningLotto = new WinningLotto(winning, bonusNumber);

        //when
        Map<Rank, Integer> map = Statistics.getWinningStatistics(userLotto, winningLotto);

        //then
        assertThat(map.get(FIRST)).isEqualTo(0);
        assertThat(map.get(SECOND)).isEqualTo(0);
        assertThat(map.get(THIRD)).isEqualTo(0);
        assertThat(map.get(FOURTH)).isEqualTo(0);
        assertThat(map.get(FIFTH)).isEqualTo(2);
        assertThat(map.get(MISS)).isEqualTo(1);
    }

    @Test
    void 총_당첨_금액을_구하는_경우() {
        //given
        Map<Rank, Integer> map = new HashMap<>();

        map.put(FIRST, 0);
        map.put(SECOND, 0);
        map.put(THIRD, 0);
        map.put(FOURTH, 0);
        map.put(FIFTH, 2);
        map.put(MISS, 1);

        //when
        int winningMoney = Statistics.getTotalWinningMoney(map);

        //then
        assertThat(winningMoney).isEqualTo(10000);

    }

    @Test
    void 총_수익률을_구하는_경우() {
        //given
        double winningMoney = 10000;
        int amount = 3;

        //when
        double totalYield = Statistics.getTotalYield(winningMoney, amount);

        //then
        assertThat(totalYield).isEqualTo(3.3333333333333335);
    }
}
