package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.ErrorChecker

@DisplayName("에러 출력 테스트")
class ErrorCheckerTest {
    private val errorChecker = ErrorChecker

    @Test
    @DisplayName("자동차명이 5자를 초과할 경우 에러 발생")
    fun `자동차명이 5자를 초과할 경우 에러 발생`() {
        val carName = "aaaaaa"

        assertThrows<IllegalArgumentException> {
            errorChecker.checkCarNameLength(carName)
        }
    }

    @Test
    @DisplayName("자동차명이 공백이거나 공백을 포함할 경우 에러 발생")
    fun `자동차명이 공백이거나 공백을 포함할 경우 에러 발생`() {
        val carName = " aa"

        assertThrows<IllegalArgumentException> {
            errorChecker.checkValidInput(carName)
        }
    }

    @Test
    @DisplayName("시도 횟수가 숫자 형식이 아닐 경우 에러 발생")
    fun `시도 횟수가 숫자 형식이 아닐 경우 에러 발생`() {
        val tryNumber = "a"

        assertThrows<IllegalArgumentException> {
            errorChecker.checkNumberType(tryNumber)
        }
    }

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 에러 발생")
    fun `시도 횟수가 0 이하일 경우 에러 발생`() {
        val tryNumber = 0

        assertThrows<IllegalArgumentException> {
            errorChecker.checkNumberLength(tryNumber)
        }
    }
}