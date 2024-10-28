package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트(단독 우승)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains(
                    "pobi : -", "pobi : --",
                    "woni : ", "woni : -",
                    "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `기능 테스트(공동 우승)`() {
        assertRandomNumberInRangeTest(
            {
                run("caca,board,nike", "4")
                assertThat(output()).contains(
                    "caca : -", "caca : --", "caca : ---", "caca : ---",
                    "board : -", "board : --", "board : --", "board : --",
                    "nike : ", "nike : -", "nike : --", "nike : ---",
                    "최종 우승자 : caca, nike")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            STOP, STOP, MOVING_FORWARD,
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
