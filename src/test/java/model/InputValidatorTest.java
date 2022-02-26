package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class InputValidatorTest {
    @Test
    void 구입_금액이_1000원_이하인_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        int cost = 500;

        //when
        boolean result = inputValidator.isValidateCostMinCost(cost);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 구입_금액이_1000원_이상인_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        int cost = 2000;

        //when
        boolean result = inputValidator.isValidateCostMinCost(cost);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 구입_금액의_단위가_1000원이_아닌_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        int cost = 2500;

        //when
        boolean result = inputValidator.isValidateCostUnit(cost);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 구입_금액의_단위가_1000원인_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        int cost = 3000;

        //when
        boolean result = inputValidator.isValidateCostUnit(cost);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 보너스_숫자의_범위가_초과한_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        int bonusNumber = 50;

        //when
        boolean result = inputValidator.isValidateBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 보너스_숫자의_범위가_초과하지_않은_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        int bonusNumber = 31;

        //when
        boolean result = inputValidator.isValidateBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 당첨_번호_6개를_입력하지_않은_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        String[] winningNumbers = new String[4];

        //when
        boolean result = inputValidator.isValidateWinningNumberLength(winningNumbers);

        //then
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 당첨_번호_6개를_알맞게_입력했을_경우() {
        //given
        InputValidator inputValidator = new InputValidator();
        String[] winningNumbers = new String[6];

        //when
        boolean result = inputValidator.isValidateWinningNumberLength(winningNumbers);

        //then
        assertThat(result).isEqualTo(true);
    }
}
