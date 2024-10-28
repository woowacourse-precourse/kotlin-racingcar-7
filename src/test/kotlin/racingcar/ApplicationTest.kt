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
    fun `기능 테스트 3명 이상`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains("pobi : -", "woni : ", "jun : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트 2명 이상의 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun,a,b", "3")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : ",
                    "a : ",
                    "b : ",
                    "최종 우승자 : pobi, woni, jun, a, b"
                )
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `기능 테스트 공백 제거`() {
        assertRandomNumberInRangeTest(
            {
                run("  a , b , c", "3")
                assertThat(output()).contains(
                    "a : -",
                    "b : -",
                    "c : -",
                    "최종 우승자 : a, b, c"
                )
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }

            exception.printStackTrace()
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
