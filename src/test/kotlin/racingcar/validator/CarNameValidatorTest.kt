package racingcar.validator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = arrayOf("길이초과자동차", "", "iamsix"))
    fun `자동차 이름 길이가 0 이거나 5보다 크다면 예외가 발생한다`(carName: String) {
        assertThatIllegalArgumentException().isThrownBy {
            CarNameValidator.validate(carName)
        }
    }

    @Test
    fun `자동차 이름 길이가 1~5 범위에 포함된다면 자동차 이름을 반환한다`() {
        // given
        val carNames = "w,wo,wtc,tech,woowa"
        val expected = "w,wo,wtc,tech,woowa"

        // when && then
        Assertions.assertEquals(expected, CarNameValidator.validate(carNames))
    }

    @Test
    fun `자동차 이름이 중복된다면 예외가 발생한다`() {
        // given
        val carNames = "pobi,pobi"

        // when && then
        assertThatIllegalArgumentException().isThrownBy {
            CarNameValidator.validate(carNames)
        }
    }

}