package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ValidatorTest {
    @Test
    void 구입_금액이_1000원_이하인_경우() {
        //given
        int cost = 500;

        //when
        boolean result = Validator.isValidCost(cost);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 구입_금액이_1000원_이상인_경우() {
        //given
        int cost = 2000;

        //when
        boolean result = Validator.isValidCost(cost);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 구입_금액의_단위가_1000원이_아닌_경우() {
        //given
        int cost = 2500;

        //when
        boolean result = Validator.isValidCost(cost);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 구입_금액의_단위가_1000원인_경우() {
        //given
        int cost = 3000;

        //when
        boolean result = Validator.isValidCost(cost);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 보너스_숫자의_범위가_초과된_경우() {
        //given
        int bonusNumber = 50;

        //when
        boolean result = Validator.isValidBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 보너스_숫자의_범위가_초과되지_않은_경우() {
        //given
        int bonusNumber = 31;

        //when
        boolean result = Validator.isValidBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 당첨_번호_6개를_입력하지_않은_경우() {
        //given
        String[] winningNumbers = new String[4];

        //when
        boolean result = Validator.isValidNumberLength(winningNumbers);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 당첨_번호_6개를_알맞게_입력했을_경우() {
        //given
        String[] winningNumbers = new String[6];

        //when
        boolean result = Validator.isValidNumberLength(winningNumbers);

        //then
        assertThat(result).isEqualTo(true);
    }
}
