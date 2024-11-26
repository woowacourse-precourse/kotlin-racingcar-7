package racingcar.validator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputTryNumberValidatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = ["a", "10a"]
    )
    fun `숫자가 아닌 문자열 예외 처리`(rawInput: String) {
        assertThrows<IllegalArgumentException> { InputTryNumberValidator.validate(rawInput) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["0", "-10", "-3"]
    )
    fun `0보다 낮은 시도 횟수 예외 처리`(rawInput: String) {
        assertThrows<IllegalArgumentException> { InputTryNumberValidator.validate(rawInput) }
    }
}