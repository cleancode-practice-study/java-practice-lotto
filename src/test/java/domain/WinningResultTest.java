package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    @Test
    public void 당첨_결과_생성() {
        // create lotto
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto);

        Lottoes lottoes = new Lottoes(lottos);

        // create winningLotto
        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        Lotto winLotto = new Lotto(winningLottoNumber);

        WinningLotto winningLotto = new WinningLotto(winLotto, bonus);

        // create lottoWinResult
        WinningResult lottoWinResult = lottoes.getLottoWinResult(winningLotto);

        assertThat(lottoWinResult.getLottoResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoWinResult.getLottoResult().get(Rank.SECOND)).isEqualTo(1);
    }
}
