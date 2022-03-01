package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 랜덤_숫자를_생성하는_경우() {
        // when
        List<Integer> randomNumbers = Lotto.getRandomNumber();

        //then
        assertThat(randomNumbers.size()).isEqualTo(6);
    }

    @Test
    void 보너스_숫자가_포함되는_경우() {
        //given
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        Lotto lotto = new Lotto(userNumbers);
        int bonusNumber = 2;

        //when
        boolean result = lotto.isContainsBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 보너스_숫자가_포함되지_않는_경우() {
        //given
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        Lotto lotto = new Lotto(userNumbers);
        int bonusNumber = 5;

        //when
        boolean result = lotto.isContainsBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(false);
    }
}
