package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 사용자_로또와_당첨_로또의_매치_갯수를_구하는_경우() {
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

        //when
        int matchCount = userLotto.getMatchCount(winningLotto);

        //then
        assertThat(matchCount).isEqualTo(3);
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
