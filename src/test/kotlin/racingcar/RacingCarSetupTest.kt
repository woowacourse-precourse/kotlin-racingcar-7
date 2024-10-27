package racingcar

import NsTestCopy
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarSetupTest : NsTestCopy() {
    override fun runFunction() {
        RacingCarSetup()
    }

    @Test
    fun `시도할 횟수에 숫자가 아닌 값 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, ddangdin", "a") }
        }
    }
}
