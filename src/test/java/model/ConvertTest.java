package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertTest {
    @Test
    void 당첨_번호를_쉼표_기준으로_자르는_경우() {
        //given
        String number = "1,2,3";

        //when
        String[] numbers = Convert.splitNumbers(number);

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
        List<Integer> list = Convert.changeStringArrayToList(array);

        //then
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(3);
    }
}
