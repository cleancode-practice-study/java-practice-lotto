package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 사용자_로또와_당첨_로또의_매치_갯수를_구하는_경우() {
        //given
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 15, 27));

        Lotto userLotto = new Lotto(userNumber);
        Lotto winningLotto = new Lotto(winningNumber);

        //when
        int matchCount = userLotto.getMatchCount(winningLotto);

        //then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 보너스_숫자가_포함되는_경우() {
        //given
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

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
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(userNumbers);
        int bonusNumber = 8;

        //when
        boolean result = lotto.isContainsBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(false);
    }
}
