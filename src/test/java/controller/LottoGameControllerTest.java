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
}
