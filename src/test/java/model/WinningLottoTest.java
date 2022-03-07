package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void 사용자_로또와_당첨_로또를_매치하는_경우() {
        //given
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 15, 27));

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
