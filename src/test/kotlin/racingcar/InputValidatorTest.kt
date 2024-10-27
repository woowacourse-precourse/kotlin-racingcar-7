package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름 입력 값이 5자 초과하는 경우 예외 발생")
    fun `자동차 이름이 5자를 초과할 때 예외 발생`() {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateInput("seohyeon,sumin", "1")
        }
    }

    @Test
    @DisplayName("자동차 이름이 ','로 구분되지 않는 경우 예외 발생")
    fun `자동차 이름이 콤마로 구분되지 않을 때 예외 발생`() {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateInput("hyeonsumin", "1")
        }
    }

    @Test
    @DisplayName("이동 횟수 입력 값이 숫자가 아닌 경우 예외 발생")
    fun `이동 횟수가 숫자가 아닐 때 예외 발생`() {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateInput("hyeon", "number")
        }
    }

    @Test
    @DisplayName("이동 횟수 입력 값이 소수인 경우 예외 발생")
    fun `이동 횟수가 소수일 때 예외 발생`() {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateInput("hyeon", "0.312")
        }
    }

    @Test
    @DisplayName("이동 횟수 입력 값이 음수인 경우 예외 발생")
    fun `이동 횟수가 음수일 때 예외 발생`() {
        val inputValidator = InputValidator()
        assertThrows<IllegalArgumentException> {
            inputValidator.validateInput("hyeon", "-1")
        }
    }
}