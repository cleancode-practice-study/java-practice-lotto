package domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameHelperTest {
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;

    @Test
    public void 로또_개수_계산() {
        GameHelper helper = new GameHelper();

        int lottoPrice = 5000;

        assertThat(helper.getLottoCount(lottoPrice)).isEqualTo(5);
    }

    @Test
    public void 로또_한_줄_생성() {
        GameHelper helper = new GameHelper();

        Lotto lotto = helper.createOneLotto();

        for(int number : lotto.getLottoNum()) {
            assertThat(number).isBetween(LOTTO_NUM_START, LOTTO_NUM_END);
        }
    }

    @Test
    public void 올바른_당첨_로또_번호_받은_경우() {
        GameHelper helper = new GameHelper();

        String winningLottoNumber = "1,2,3,4,5,6";

        assertThat(helper.checkDuplicatedNumber(winningLottoNumber)).isTrue();
    }

    @Test
    public void 올바르지_않은_당첨_로또_번호_받은_경우() {
        GameHelper helper = new GameHelper();

        String winningLottoNumber = "3,3,1,2,4,5";

        assertThat(helper.checkDuplicatedNumber(winningLottoNumber)).isFalse();
    }

    @Test
    public void 당첨_로또_객체_생성() {
        GameHelper helper = new GameHelper();

        String winningLottoNumber = "1,2,3,4,5,6";
        int bonusNumber = 7;

        WinningLotto winningLotto = helper.createWinningLotto(winningLottoNumber, bonusNumber);

        assertThat(winningLotto.getLotto().getLottoNum()).contains(1,2,3,4,5,6);
        assertThat(winningLotto.getBonusNo()).isEqualTo(7);
    }

    @Test
    public void 로또_당첨_결과_확인() {
        GameHelper helper = new GameHelper();

        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.FIFTH, 1);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 1);
        lottoResult.put(Rank.FIRST, 1);

        List<Integer> lottoWinResult = helper.getLottoWinResult(lottoResult);

        assertThat(lottoWinResult).isNotNull().contains(1, 0, 0, 1, 1);
    }
}
