package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `기능 테스트`() {

        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jisu", "5")
                assertThat(output()).contains("pobi : -", "woni : ", "jisu :", "최종 우승자 : pobi")
                assertThat(tryCounts).isEqualTo(5)
                assertThat(carNames).containsExactly("pobi", "woni", "jisu")
                assertThat(moveCounts).containsExactly(1, 0, 0)
            },
            MOVING_FORWARD, STOP
        )

        assertRandomNumberInRangeTest(
            {
                carNames = mutableListOf<String>()
                moveCounts = mutableListOf<Int>()
                tryCounts = 0
                run("pobi,woni,jisu", "5")
                assertThat(output()).contains("최종 우승자 : woni,jisu")
                assertThat(tryCounts).isEqualTo(5)
                assertThat(carNames).containsExactly("pobi", "woni", "jisu")
                assertThat(moveCounts).containsExactly(4, 5, 5)

            },
            2, 4
        )

    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi, woni", "das") }
            assertThrows<IllegalArgumentException> { runException("pobi,, woni", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi, woni", "-1") }

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
