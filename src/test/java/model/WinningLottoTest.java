package model;

import org.junit.jupiter.api.Test;

import static model.WinningLotto.splitWinningNumber;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    void 당첨_번호를_쉼표_기준으로_자르는_경우() {
        //given
        String number = "1,2,3";

        //when
        String[] numbers = splitWinningNumber(number);

        //then
        assertThat(numbers[0]).isEqualTo("1");
        assertThat(numbers[1]).isEqualTo("2");
        assertThat(numbers[2]).isEqualTo("3");
    }
}
