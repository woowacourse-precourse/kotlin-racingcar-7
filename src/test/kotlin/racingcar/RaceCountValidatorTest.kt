package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.util.ErrorMessages
import racingcar.util.RaceCountValidator

class RaceCountValidatorTest {

    @Test
    fun `경주 횟수가 숫자 형식이 아닌 경우`() {
        Assertions.assertThatThrownBy { RaceCountValidator.validatePositiveInteger("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_RACE_COUNT_FORMAT_ERROR)
    }

    @Test
    fun `경주 횟수가 소수인 경우`() {
        Assertions.assertThatThrownBy { RaceCountValidator.validatePositiveInteger("0.1") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_RACE_COUNT_DECIMAL_ERROR)
    }

    @Test
    fun `경주 횟수가 숫자가 0 이하인 경우`() {
        Assertions.assertThatThrownBy { RaceCountValidator.validatePositiveInteger("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INVALID_RACE_COUNT_POSITIVE_INTEGER_ERROR)
    }

    @Test
    fun `경주 횟수가 제한(100,000)을 넘는 경우`() {
        Assertions.assertThatThrownBy { RaceCountValidator.validateNumberSize(100_001) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ErrorMessages.INPUT_EXCEEDS_RACE_COUNT_LIMIT_ERROR)
    }

}