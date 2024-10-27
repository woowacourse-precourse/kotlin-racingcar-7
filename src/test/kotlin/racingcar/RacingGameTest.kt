package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest : NsTest() {

    @Test
    fun `단독 우승자 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : ",
                    "최종 우승자 : pobi"
                )
            },
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `공동 우승자 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : -",
                    "jun : ",
                    "최종 우승자 : pobi, woni"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `자동차 경주 진행 횟수 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains(
                    "pobi : --",
                    "woni : -",
                    "jun : "
                )
            },
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}