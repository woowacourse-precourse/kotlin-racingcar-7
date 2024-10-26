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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }

            // null or 공백만 있는 경우
            assertThrows<IllegalArgumentException> { runException(null, "1") }
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
            assertThrows<IllegalArgumentException> { runException("", "1") }

            // 6자 이상인 경우
            assertThrows<IllegalArgumentException> { runException("c,java,kotlin", "1") }
        }
    }

    @Test
    fun `공동 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,ji", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "ji : -", "최종 우승자 : pobi,woni,ji")
            },
            MOVING_FORWARD, STOP
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
