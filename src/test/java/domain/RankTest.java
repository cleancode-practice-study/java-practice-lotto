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
    }

    @Test
    public void 로또_번호_5개_일치_보너스_볼_맞음() {
        int countOfMatch = 5;
        boolean matchBonus = true;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 로또_번호_5개_일치_보너스_볼_다름() {
        int countOfMatch = 5;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 로또_번호_4개_일치() {
        int countOfMatch = 4;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 로또_번호_3개_일치() {
        int countOfMatch = 3;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 로또_번호_3개_미만_일치() {
        int countOfMatch = 2;
        boolean matchBonus = false;
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);

        assertThat(rank).isEqualTo(Rank.MISS);
    }

}
