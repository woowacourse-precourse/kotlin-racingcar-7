package racingcar.validator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RoundValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1a", "1 2", "4  ", "1.2", "3d", "4.0f"))
    fun `라운드에 숫자 외에 다른 문자가 들어올 경우 예외를 반환한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            RoundValidator.validate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("0", "10001", "2147483647", "4294967294"))
    fun `라운드에 1 ~ 10_000 범위 밖 숫자는 예외를 반환한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            RoundValidator.validate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("1", "100", "10000"))
    fun `라운드가 1 ~ 10_000 범위 안에 있는 숫자라면 정상적 출력한다`(input: String) {
        // given
        val expected = input.toInt()

        // when
        val actual = RoundValidator.validate(input)

        // then
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual)
    }
}