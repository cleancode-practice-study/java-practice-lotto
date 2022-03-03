package model;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    void 사용자의_로또를_생성하는_경우() {
        //given
        int count = 5;

        // when
        List<Lotto> userLotto = User.getTotalLotto(count);

        //then
        assertThat(userLotto.size()).isEqualTo(5);
    }

    @Test
    void 사용자가_구입한_로또_갯수를_구하는_경우() {
        //given
        int cost = 5000;

        //when
        int amount = User.getCount(cost);

        //then
        AssertionsForClassTypes.assertThat(amount).isEqualTo(5);
    }
}
