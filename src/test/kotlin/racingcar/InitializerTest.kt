package racingcar

import NsTestCopy
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InitializerTest : NsTestCopy() {
    override fun runFunction() {
        Initializer()
    }

    @Test
    fun `자동차 이름이 5자 이하일 때 통과 테스트`() {
        assertDoesNotThrow { runException("${FOUR_LETTER_WORD},$FIVE_LETTER_WORD") }
    }

    @Test
    fun `자동차 이름이 5자 초과 시 예외 테스트`() {
        assertThrows<IllegalArgumentException> { runException("$SIX_LETTER_WORD,$FOUR_LETTER_WORD") }
    }

    @Test
    fun `시도할 횟수에 숫자 입력 시 통과 테스트`() {
        assertDoesNotThrow { runException("x,y", NUMBER) }
    }

    @Test
    fun `시도할 횟수에 숫자가 아닌 값 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("x,y", NOT_NUMBER) }
        }
    }

    companion object {
        private const val FOUR_LETTER_WORD = "1234"
        private const val FIVE_LETTER_WORD = "12345"
        private const val SIX_LETTER_WORD = "123456"
        private const val NUMBER = "1"
        private const val NOT_NUMBER = "a"
    }
}
