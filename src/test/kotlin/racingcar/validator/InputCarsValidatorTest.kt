package racingcar.validator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputCarsValidatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = ["", ","]
    )
    fun `공백 예외 처리`(rawInput: String) {
        assertThrows<IllegalArgumentException> { InputCarsValidator.validate(rawInput) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["ijh1298,pobi,jinu", "junhyuk", "pobi,junhyuk"]
    )
    fun `5글자 이상 자동차 이름 예외 처리`(rawInput: String) {
        assertThrows<IllegalArgumentException> { InputCarsValidator.validate(rawInput) }
    }
}