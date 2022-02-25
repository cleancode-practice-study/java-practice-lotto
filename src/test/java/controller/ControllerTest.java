package controller;

import domain.Lotto;
import domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;

    @Test
    public void 로또_개수_계산() {
        Controller controller = new Controller();

        int lottoPrice = 5000;

        assertThat(controller.getLottoCount(lottoPrice)).isEqualTo(5);
    }

    @Test
    public void 로또_한_줄_생성() {
        Controller controller = new Controller();

        Lotto lotto = controller.createOneLotto();

        for(int number : lotto.getLottoNum()) {
            assertThat(number).isBetween(LOTTO_NUM_START, LOTTO_NUM_END);
        }
    }

    @Test
    public void 올바른_당첨_로또_번호_받은_경우() {
        Controller controller = new Controller();

        String winningLottoNumber = "1,2,3,4,5,6";

        Set<Integer> winningNumber = controller.splitWinnigLottoNumber(winningLottoNumber);

        assertThat(controller.checkDuplicatedNumber(winningNumber)).isTrue();
    }

    @Test
    public void 올바르지_않은_당첨_로또_번호_받은_경우() {
        Controller controller = new Controller();

        String winningLottoNumber = "3,3,1,2,4,5";

        Set<Integer> winningNumber = controller.splitWinnigLottoNumber(winningLottoNumber);

        assertThat(controller.checkDuplicatedNumber(winningNumber)).isFalse();
    }

    @Test
    public void 로또_당첨_결과_확인() {
        Controller controller = new Controller();

        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.FIFTH, 1);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 1);
        lottoResult.put(Rank.FIRST, 1);

        List<Integer> lottoWinResult = controller.getLottoWinResult(lottoResult);

        assertThat(lottoWinResult).isNotNull().contains(1, 0, 0, 1, 1);
    }

}
