package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    private val inputValidator = InputValidator()

    @Test
    fun `자동차이름 정상입력_에러발생없음`() {
        val input = listOf("pobi", "woni", "jun")
        assertDoesNotThrow {
            inputValidator.validateCarNames(input)
        }
    }

    @Test
    fun `빈 문자열의 자동차이름 입력_에러발생`() {
        val input = listOf("pobi", "", "woni", "junlongname")
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(input)
        }
        // 예외 메시지 검증
        assertEquals(InputValidator.CAR_NAME_BLANK_ERROR, exception.message)
    }

    @Test
    fun `공백 문자열의 자동차이름 입력_에러발생`() {
        val input = listOf("pobi", " ", "woni", "junlongname")
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(input)
        }
        // 예외 메시지 검증
        assertEquals(InputValidator.CAR_NAME_BLANK_ERROR, exception.message)
    }


    @Test
    fun `5자초과입력_에러발생`() {
        val input = listOf("pobi", "woni", "junlongname")
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(input)
        }
        // 예외 메시지 검증
        assertEquals(InputValidator.CAR_NAME_TOO_LONG_ERROR, exception.message)
    }

    @Test
    fun `자동차이름이 없는 입력_에러발생`() {
        val input = listOf<String>()
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(input)
        }
        // 예외 메시지 검증
        assertEquals(InputValidator.CAR_NAME_EMPTY_ERROR, exception.message)
    }

    @Test
    fun `시도횟수 1이상 입력_에러발생없음`() {
        assertDoesNotThrow {
            inputValidator.validateTryCount(5)
        }
    }

    @Test
    fun `시도횟수 0 입력_에러발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateTryCount(0)
        }
        // 예외 메시지 검증
        assertEquals(InputValidator.TRY_COUNT_TOO_SMALL_ERROR, exception.message)
    }

    @Test
    fun `시도횟수 -1 입력_에러발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateTryCount(-1)
        }
        // 예외 메시지 검증
        assertEquals(InputValidator.TRY_COUNT_TOO_SMALL_ERROR, exception.message)
    }
}