package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트2`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun,john", "3")
                assertThat(output()).contains(
                    "pobi : -", "pobi : --", "pobi : ---",
                    "woni : -", "woni : --",
                    "jun : -", "jun : --",
                    "john : -", "john : --", "john : ---",
                    "최종 우승자 : pobi, john"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
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
