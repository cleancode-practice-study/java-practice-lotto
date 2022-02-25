package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void 로또_번호_6개_일치() {
        int countOfMatch = 6;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getCountOfMatch()).isEqualTo(6);
        assertThat(rank.getWinningMoney()).isEqualTo(2000000000);
    }

    @Test
    public void 로또_번호_5개_일치_보너스_볼_맞음() {
        int countOfMatch = 5;
        boolean matchBonus = true;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getCountOfMatch()).isEqualTo(5);
        assertThat(rank.getWinningMoney()).isEqualTo(30000000);
    }

    @Test
    public void 로또_번호_5개_일치_보너스_볼_다름() {
        int countOfMatch = 5;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getCountOfMatch()).isEqualTo(5);
        assertThat(rank.getWinningMoney()).isEqualTo(1500000);
    }

    @Test
    public void 로또_번호_4개_일치() {
        int countOfMatch = 4;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getCountOfMatch()).isEqualTo(4);
        assertThat(rank.getWinningMoney()).isEqualTo(50000);
    }

    @Test
    public void 로또_번호_3개_일치() {
        int countOfMatch = 3;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getCountOfMatch()).isEqualTo(3);
        assertThat(rank.getWinningMoney()).isEqualTo(5000);
    }

    @Test
    public void 로또_번호_3개_미만_일치() {
        int countOfMatch = 2;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.MISS);
        assertThat(rank.getCountOfMatch()).isEqualTo(0);
        assertThat(rank.getWinningMoney()).isEqualTo(0);
    }

}
