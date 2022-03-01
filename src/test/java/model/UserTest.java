package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
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
}
