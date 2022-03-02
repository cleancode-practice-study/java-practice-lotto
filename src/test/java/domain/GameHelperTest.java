package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameHelperTest {
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;
    private static final int LOTTO_NUM_PER_ONE_LINE = 6;

    @Test
    public void 로또_개수_계산() {
        int lottoPrice = 5000;

        assertThat(GameHelper.getLottoCount(lottoPrice)).isEqualTo(5);
    }

    @Test
    public void 로또_생성() {
        List<Lotto> lottoes = GameHelper.createLottoes(3);
        for(Lotto lotto : lottoes) {
            for(int lottoNumber : lotto.getLottoNum()) {
                assertThat(lottoNumber).isBetween(LOTTO_NUM_START, LOTTO_NUM_END);
            }
        }
    }

    @Test
    public void 올바른_당첨_로또_번호_받은_경우() {
        String winningLottoNumber = "1,2,3,4,5,6";

        assertThat(GameHelper.checkDuplicatedNumber(winningLottoNumber)).isTrue();
    }

    @Test
    public void 올바르지_않은_당첨_로또_번호_받은_경우() {
        String winningLottoNumber = "3,3,1,2,4,5";

        assertThat(GameHelper.checkDuplicatedNumber(winningLottoNumber)).isFalse();
    }


    @Test
    public void 당첨_로또_객체_생성() {
        String winningLottoNumber = "1,2,3,4,5,6";
        int bonusNumber = 7;

        WinningLotto winningLotto = GameHelper.createWinningLotto(winningLottoNumber, bonusNumber);

        assertThat(winningLotto.getLotto().getLottoNum()).contains(1,2,3,4,5,6);
        assertThat(winningLotto.getBonusNo()).isEqualTo(7);
    }

    @Test
    public void 로또_당첨_결과_확인() {
        List<Integer> lottoOneNumber = Arrays.asList(1,2,3,4,5,6);
        List<Integer> lottoTwoNumber = Arrays.asList(1,2,3,4,5,7);
        Lotto lottoOne = new Lotto(lottoOneNumber);
        Lotto lottoTwo = new Lotto(lottoTwoNumber);

        List<Lotto> lottoes = Arrays.asList(lottoOne, lottoTwo);

        Lotto lottoForWinningLotto = new Lotto(lottoOneNumber);

        WinningLotto winningLotto = new WinningLotto(lottoForWinningLotto, 7);

        Map<Rank, Integer> lottoWinResult = GameHelper.getLottoWinResult(winningLotto, lottoes);

        assertThat(lottoWinResult.get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoWinResult.get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoWinResult.get(Rank.FIFTH)).isEqualTo(0);
    }

    @Test
    public void 수익률_구하기() {
        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.MISS, 0);
        lottoResult.put(Rank.FIFTH, 1);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 1);
        lottoResult.put(Rank.SECOND, 1);
        lottoResult.put(Rank.FIRST, 0);

        int lottoPrice = 5000;

        double yield = GameHelper.getYield(lottoResult, lottoPrice);

        assertThat(yield).isEqualTo(6301);
    }
}
