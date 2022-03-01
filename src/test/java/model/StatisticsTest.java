package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {
    @Test
    void 총_수익률을_구하는_경우() {
        //given
        Statistics statistics = new Statistics();
        double winningMoney = 5000;
        int amount = 3;

        //when
        double totalYield = statistics.getTotalYield(winningMoney, amount);

        //then
        assertThat(totalYield).isEqualTo(1.6666666666666667);
    }
}
