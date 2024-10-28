package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class RaceResultTest : NsTest() {
    @Test
    fun `결과 출력 기능 테스트`() {
        Assertions.assertRandomNumberInRangeTest(
            {
                run("pobi,woni,lim", "3")
                assertThat(output()).contains("pobi", "lim")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
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