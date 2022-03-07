package model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static model.Rank.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {
    @Test
    void 당첨_통계를_구하는_경우() {
        //given
        List<Integer> firstLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> secondLotto = new ArrayList<>(Arrays.asList(10, 15, 22, 33, 40, 41));
        List<Integer> thirdLotto = new ArrayList<>(Arrays.asList(8, 11, 14, 31, 38, 44));

        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(10, 11, 14, 31, 40, 41));
        int bonusNumber = 8;

        Lotto first = new Lotto(firstLotto);
        Lotto second = new Lotto(secondLotto);
        Lotto third = new Lotto(thirdLotto);
        Lotto winning = new Lotto(winningNumber);

        List<Lotto> userLotto = Arrays.asList(first, second, third);
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
        Map<Rank, Integer> map = new HashMap<Rank, Integer>() {{
            put(FIRST, 0);
            put(SECOND, 0);
            put(THIRD, 0);
            put(FOURTH, 0);
            put(FIFTH, 2);
            put(MISS, 1);
        }};

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
