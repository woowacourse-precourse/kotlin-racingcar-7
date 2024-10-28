package racingcar.domain.validator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigInteger

class ValidateTryNumberKtTest {
    @Test
    fun `시도 횟수가 양수일 경우 아무일도 일어나지 않음`() {
        // act, assert
        assertDoesNotThrow { validateTryNumber(BigInteger("1")) }
    }

    @Test
    fun `시도 횟수가 0일 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateTryNumber(BigInteger("0")) }
    }

    @Test
    fun `시도 횟수가 음수일 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateTryNumber(BigInteger("-1")) }
    }

    @Test
    fun `시도 횟수가 정수가 아닐 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateTryNumber(BigInteger("1.2")) }
    }

    @Test
    fun `시도 횟수로 문자열이 입력될 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { validateTryNumber(BigInteger("hello world")) }
    }
}
