package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_객체_생성() {
        List<Integer> lottoNumber = new ArrayList<>();

        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);

        Lotto lotto = new Lotto(lottoNumber);

        assertThat(lotto.getLottoNum()).contains(1,2,3,4,5,6);
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

        Lotto winningLotto = new Lotto(winningLottoNumber);

        assertThat(lotto.countOfMatch(winningLotto)).isEqualTo(6);
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
        int winningBonus = 7;

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(5);
        winningLottoNumber.add(8);

        Lotto winningLotto = new Lotto(winningLottoNumber);

        assertThat(lotto.countOfMatch(winningLotto)).isEqualTo(5);
        assertThat(lotto.countOfBonus(winningBonus)).isTrue();
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
        int winningBonus = 7;

        winningLottoNumber.add(1);
        winningLottoNumber.add(2);
        winningLottoNumber.add(3);
        winningLottoNumber.add(4);
        winningLottoNumber.add(5);
        winningLottoNumber.add(8);

        Lotto winningLotto = new Lotto(winningLottoNumber);

        assertThat(lotto.countOfMatch(winningLotto)).isEqualTo(5);
        assertThat(lotto.countOfBonus(winningBonus)).isFalse();
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

        Lotto winningLotto = new Lotto(winningLottoNumber);

        assertThat(lotto.countOfMatch(winningLotto)).isEqualTo(4);
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
        winningLottoNumber.add(7);
        winningLottoNumber.add(8);
        winningLottoNumber.add(9);

        Lotto winningLotto = new Lotto(winningLottoNumber);

        assertThat(lotto.countOfMatch(winningLotto)).isEqualTo(3);
    }
}
