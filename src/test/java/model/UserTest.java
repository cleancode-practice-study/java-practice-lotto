package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    @Test
    void 랜덤_로또_생성() {
        //given
        User user = new User();
        int count = 5;

        //when
        List<Lotto> lotto = user.getRandomLottoNumber(count);

        //then
        assertThat(lotto.size()).isEqualTo(5);
    }

    @Test
    void 사용자가_구매한_로또_갯수_계산() {
        //given
        User user = new User();
        int cost = 5000;

        //when
        int amount = user.calculateCount(cost);

        //then
        assertThat(amount).isEqualTo(5);
    }

    @Test
    void 총_수익률_test() {
        //given
        User user = new User();
        double winningMoney = 5000;
        int amount = 3;

        //when
        double totalYield = user.getTotalYield(winningMoney, amount);

        //then
        assertThat(totalYield).isEqualTo(1.6666666666666667);
    }


}
