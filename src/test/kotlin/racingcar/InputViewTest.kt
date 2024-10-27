package racingcar

import View.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.test.NsTest

class InputViewTest : NsTest() {
    @Test
    fun `이동 횟수가 0일 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("pobi,woni", "0")
        }
    }

    @Test
    fun `이동 횟수가 음수일 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("pobi,woni", "-1")
        }
    }

    @Test
    fun `이동 횟수에 숫자가 아닌 문자를 입력한 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("pobi,woni", "one")
        }
    }

    override fun runMain() {
        main()
    }
}
