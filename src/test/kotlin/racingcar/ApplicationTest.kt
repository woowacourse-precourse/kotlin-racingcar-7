package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트 - 우승자 1명`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트 - 우승자 2명 이상`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi,woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `기능 테스트 - 시도 횟수 2회 이상`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트 - 게임 참가자 3명 이상`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains("pobi : ", "woni : -", "jun : ", "최종 우승자 : woni")
            },
            STOP, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `예외 테스트 - 자동차 이름이 5자 초과인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `예외 테스트 - 경주할 자동차 이름을 입력하지 않은 경우 (공백 입력)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `예외 테스트 - 시도할 횟수 입력시 정수가 아닌 다른 값이 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "1.1")}
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abcd")}
        }
    }

    @Test
    fun `에외 테스트 - 시도 횟수 입력시 0이 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `예외 테스트 - 시도할 횟수 입력시 음수가 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
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
