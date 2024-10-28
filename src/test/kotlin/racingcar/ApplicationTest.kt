package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트-단독 우승`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트-공동 우승`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `예외 테스트-자동차 이름이 5글자를 넘길 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `예외 테스트-자동차 이름이 공백일 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,", "1") }
        }
    }

    @Test
    fun `예외 테스트-실시횟수가 1보다 작을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `예외 테스트-실시횟수가 100보다 클 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,woni", "101") }
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
