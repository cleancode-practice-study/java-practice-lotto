package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoNumberTest {
    static private final int LOTTO_NUM_PER_ONE_LINE = 6;
    static private final int LOTTO_NUM_START_INCLUSIVE = 1;
    static private final int LOTTO_NUM_END_INCLUSIVE = 45;

    @Test
    public void 랜덤한_숫자_생성() {
        List<Integer> lottoNumbers = CreateLottoNumber.createLottosNumber();

        for (int number : lottoNumbers) {
            assertThat(number).isBetween(LOTTO_NUM_START_INCLUSIVE, LOTTO_NUM_END_INCLUSIVE);
        }
    }

    @Test
    public void 로또_생성() {
        List<Integer> lottoes = CreateLottoNumber.createLottosNumber();

        assertThat(lottoes.size()).isEqualTo(LOTTO_NUM_PER_ONE_LINE);
    }

}
