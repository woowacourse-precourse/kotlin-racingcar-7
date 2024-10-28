package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트(단독 우승자)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트(공동 우승자)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains("pobi : --", "woni : -", "jun : --", "최종 우승자 : pobi, jun")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `예외 테스트(5글자 초과)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `예외 테스트(영어가 아닌 이름 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi3,woniㄱ", "1") }
        }
    }

    @Test
    fun `예외 테스트(이름 입력 시 비어있는 자동차 이름 존재)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,", "1") }
        }
    }

    @Test
    fun `예외 테스트(중복 이름)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `예외 테스트(횟수를 음수로 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `예외 테스트(횟수를 0으로 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `예외 테스트(횟수가 입력되지 않음)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "\n") }
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
