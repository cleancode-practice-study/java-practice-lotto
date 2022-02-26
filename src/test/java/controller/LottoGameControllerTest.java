package controller;


import model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGameControllerTest {
    @Test
    void 사용자가_구매한_자동_팈로또_장수() {
        //given
        LottoGameController controller = new LottoGameController();
        int count = 5;

        //when
        List<Lotto> lotto = controller.getUserNumber(count);

        //then
        assertThat(lotto.size()).isEqualTo(5);
    }

    @Test
    void 당첨_번호_쉼표_기준으로_스플릿() {
        //given
        LottoGameController controller = new LottoGameController();
        String number = "1,2,3";

        //when
        String[] numbers = controller.splitLastWeekNumber(number);

        //then
        assertThat(numbers[0]).isEqualTo("1");
        assertThat(numbers[1]).isEqualTo("2");
        assertThat(numbers[2]).isEqualTo("3");
    }
}
