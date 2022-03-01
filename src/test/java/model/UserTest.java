package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    @Test
    void 사용자가_구입한_로또_갯수를_구하는_경우() {
        //given
        User user = new User();
        int cost = 5000;

        //when
        int amount = user.getCount(cost);

        //then
        assertThat(amount).isEqualTo(5);
    }

    @Test
    void 사용자가_구입한_로또_리스트를_생성하는_경우() {
        //given
        User user = new User();
        int count = 5;

        //when
        List<Lotto> result = user.getUserRandomLotto(count);

        //then
        assertThat(result.size()).isEqualTo(5);
    }
}
