package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void 당첨_로또_생성(){
        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        int winnigBonus = 7;

        Lotto lotto = new Lotto(winningLottoNumber);

        WinningLotto winningLotto = new WinningLotto(lotto, winnigBonus);

        assertThat(winningLotto.getLotto().getLottoNum()).isNotNull().contains(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNo()).isNotNull().isEqualTo(7);
    }

    @Test
    public void 로또가_1등인_경우() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 로또가_2등인_경우() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 7);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 로또가_3등인_경우() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 8);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 로또가_4등인_경우() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 8, 9);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 로또가_5등인_경우() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 8, 9, 10);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또가_낙첨인_경우() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = Arrays.asList(10, 11, 12, 13, 14, 15);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.MISS);
    }
}
