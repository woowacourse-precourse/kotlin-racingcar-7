package racingcar.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ErrorKtTest {
    private val error = Error()

    @Test
    fun `차 이름을 입력하지 않았을 때 테스트`() {
        val caNames = ""
        val result = error.carNameError(caNames)

        assertTrue(result)
    }

    @Test
    fun `차 이름의 길이가 5글자를 초과할 때 테스트`() {
        val caNames = "a,b,cdefghi"
        val result = error.carNameError(caNames)

        assertTrue(result)
    }

    @Test
    fun `차 이름이 중복될 때 테스트`() {
        val caNames ="a,a,b"
        val result = error.carNameError(caNames)

        assertTrue(result)
    }

    @Test
    fun `시도 횟수가 숫자가 아닐 때 테스트`() {
        val tryCount = "a"
        val result = error.tryCountError(tryCount)

        assertTrue(result)
    }

    @Test
    fun `시도 횟수가 음수일 때 테스트`() {
        val tryCount = "-1"
        val result = error.tryCountError(tryCount)

        assertTrue(result)
    }
}
