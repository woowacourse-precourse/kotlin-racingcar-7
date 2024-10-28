package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `단독 우승 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `공동 우승 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains(
                    "pobi : -", "pobi : --", "pobi : ---", "pobi : ----", "pobi : -----",
                    "woni : ", "woni : -", "woni : --", "woni : ---", "woni : ----",
                    "jun : -", "jun : --", "jun : ---", "jun : ----", "jun : -----",
                    "최종 우승자 : pobi, jun"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, // round 1
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // round 5
        )
    }

    @Test
    fun `공동 우승 중복 이름 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("ark,eco,ark,deca,eco", "3")
                assertThat(output()).contains(
                    "ark_0 : ", "ark_0 : -", "ark_0 : -",
                    "ark_1 : ", "ark_1 : -", "ark_1 : --",
                    "eco_0 : -", "eco_0 : --", "eco_0 : ---",
                    "eco_1 : -", "eco_1 : --", "eco_1 : ---",
                    "deca : -", "deca : --", "deca : ---",
                    "최종 우승자 : eco_0, eco_1, deca"
                )
            },
            STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // round 1
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,// round 3
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
