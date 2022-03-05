package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void 사용자_로또와_당첨_로또를_매치하는_경우() {
        //given
        List<Integer> userNumber = new ArrayList<>();
        userNumber.add(1);
        userNumber.add(2);
        userNumber.add(3);
        userNumber.add(4);
        userNumber.add(5);
        userNumber.add(6);

        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(8);
        winningNumber.add(15);
        winningNumber.add(27);

        Lotto userLotto = new Lotto(userNumber);
        Lotto winningLotto = new Lotto(winningNumber);
        int bonusNumber = 6;
        WinningLotto winning = new WinningLotto(winningLotto, bonusNumber);

        //when
        Rank rank = winning.match(userLotto);

        //then
        assertThat(rank.getWinningMoney()).isEqualTo(5000);
        assertThat(rank.getCountOfMatch()).isEqualTo(3);
    }
}
