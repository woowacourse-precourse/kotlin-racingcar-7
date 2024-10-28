package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `단독 우승자 기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `복수 우승자 기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `이름이 5글자를 초과할 경우 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이름을 지정하지 않은 경우 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,woni", "1") }
        }
    }

    @Test
    fun `시도 횟수를 0으로 지정시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `시도 횟수를 음수로 지정시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `시도 횟수를 실수로 지정시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "4.3") }
        }
    }

    @Test
    fun `시도 횟수 입력으로 문자열 입력시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "asdf") }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
