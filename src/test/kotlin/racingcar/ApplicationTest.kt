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
    fun `기능 테스트(공동 우승자)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains("pobi : -", "woni : ","jun : -","pobi : --","jun : --", "최종 우승자 : pobi, jun")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `예외 테스트(차 이름이 5글자를 넘은 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `예외 테스트(입력된 차의 숫자가 2개 미만인 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }

    @Test
    fun `예외 테스트(차의 이름에 빈 문자가 온 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, ", "1") }
        }
    }

    @Test
    fun `예외 테스트(동일한 차의 이름이 들어온 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `예외 테스트(입력된 시행 횟수가 숫자가 아닌 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "a") }
        }
    }

    @Test
    fun `예외 테스트(입력된 시행 횟수가 양의 정수가 아닌 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "-1") }
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
