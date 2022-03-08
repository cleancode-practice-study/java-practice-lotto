package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {
    @Test
    public void 로또_생성() {
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> lottoThree = Arrays.asList(1, 2, 3, 4, 5, 8);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);
        Lotto thirdLotto = new Lotto(lottoThree);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto);

        Lottoes lottoes = new Lottoes(lottos);

        assertThat(lottoes.getLottoes()).contains(firstLotto, secondLotto, thirdLotto);
    }

    @Test
    public void 로또_개수_반환() {
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> lottoThree = Arrays.asList(1, 2, 3, 4, 5, 8);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);
        Lotto thirdLotto = new Lotto(lottoThree);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto);

        Lottoes lottoes = new Lottoes(lottos);

        assertThat(lottoes.getLottoesCount()).isEqualTo(3);
    }

    @Test
    public void 로또_당첨_결과_반환() {
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
