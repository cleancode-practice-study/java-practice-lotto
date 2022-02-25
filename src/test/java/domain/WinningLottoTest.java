package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void 당첨_로또_생성(){
        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(5);
        winningLottoNumber.add(6);

        int winnigBonus = 7;

        Lotto lotto = new Lotto(winningLottoNumber);

        WinningLotto winningLotto = new WinningLotto(lotto, winnigBonus);

        assertThat(winningLotto.getLotto().getLottoNum()).isNotNull().contains(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNo()).isNotNull().isEqualTo(7);
    }

    @Test
    public void 로또가_1등인_경우() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(5);
        winningLottoNumber.add(6);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIRST);
        assertThat(winningLotto.match(lotto).getCountOfMatch()).isEqualTo(6);
        assertThat(winningLotto.match(lotto).getWinningMoney()).isEqualTo(2000000000);
    }

    @Test
    public void 로또가_2등인_경우() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(7);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(5);
        winningLottoNumber.add(6);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.match(lotto).getCountOfMatch()).isEqualTo(5);
        assertThat(winningLotto.match(lotto).getWinningMoney()).isEqualTo(30000000);
    }

    @Test
    public void 로또가_3등인_경우() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(5);
        winningLottoNumber.add(8);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.THIRD);
        assertThat(winningLotto.match(lotto).getCountOfMatch()).isEqualTo(5);
        assertThat(winningLotto.match(lotto).getWinningMoney()).isEqualTo(1500000);
    }

    @Test
    public void 로또가_4등인_경우() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(8);
        winningLottoNumber.add(9);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.match(lotto).getCountOfMatch()).isEqualTo(4);
        assertThat(winningLotto.match(lotto).getWinningMoney()).isEqualTo(50000);
    }

    @Test
    public void 로또가_5등인_경우() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(8);
        winningLottoNumber.add(9);
        winningLottoNumber.add(10);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.FIFTH);
        assertThat(winningLotto.match(lotto).getCountOfMatch()).isEqualTo(3);
        assertThat(winningLotto.match(lotto).getWinningMoney()).isEqualTo(5000);
    }

    @Test
    public void 로또가_낙첨인_경우() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);

        Lotto lotto = new Lotto(lottoNumber);

        List<Integer> winningLottoNumber = new ArrayList<>();

        winningLottoNumber.add(10);
        winningLottoNumber.add(11);
        winningLottoNumber.add(12);
        winningLottoNumber.add(13);
        winningLottoNumber.add(14);
        winningLottoNumber.add(15);

        Lotto lotto2 = new Lotto(winningLottoNumber);

        int winningBonus = 7;

        WinningLotto winningLotto = new WinningLotto(lotto2, winningBonus);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.MISS);
        assertThat(winningLotto.match(lotto).getCountOfMatch()).isEqualTo(0);
        assertThat(winningLotto.match(lotto).getWinningMoney()).isEqualTo(0);
    }
}
