package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
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

    @Test
    void 당첨_번호를_쉼표_기준으로_자르는_경우() {
        //given
        String number = "1,2,3";

        //when
        String[] numbers = Lotto.splitNumbers(number);

        //then
        assertThat(numbers[0]).isEqualTo("1");
        assertThat(numbers[1]).isEqualTo("2");
        assertThat(numbers[2]).isEqualTo("3");
    }

    @Test
    void 배열을_리스트로_변환하는_경우() {
        //given
        String[] array = {"1", "2", "3"};

        //when
        List<Integer> list = Lotto.changeStringArrayToList(array);

        //then
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
    }
}
