package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import net.bytebuddy.pool.TypePool.Resolution.Illegal
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
        }
    }

    @Test
    fun `자동차 이름이 빈 문자열일 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<java.lang.IllegalArgumentException> { runException("", "1") }
            assertThrows<java.lang.IllegalArgumentException> { runException(",", "1") }
            assertThrows<java.lang.IllegalArgumentException> { runException("car1,", "1") }
            assertThrows<java.lang.IllegalArgumentException> { runException(",car1", "1") }
            assertThrows<java.lang.IllegalArgumentException> { runException(",car1,", "1") }
            assertThrows<java.lang.IllegalArgumentException> { runException("car1,,car2", "1") }
        }
    }

    @Test
    fun `자동차 이름이 5자를 초과할 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<java.lang.IllegalArgumentException> { runException("longCarName", "1") }
            assertThrows<java.lang.IllegalArgumentException> { runException("car1,longCarName", "1") }
        }
    }

    @Test
    fun `자동차 이름 중 중복되는 것이 있을 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("car1,car1", "1") }
            assertThrows<IllegalArgumentException> { runException("car1,car1,car2", "1") }
        }
    }

    @Test
    fun `입력된 시행 횟수가 올바른 숫자가 아닐 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("car", "notNumeric") }
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
