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
    fun `기능 테스트(차 이름 공백)`() {
        assertSimpleTest { run("a, ", "1") }
    }

    @Test
    fun `예외 테스트(차 이름 길이)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `예외 테스트(차 대수 초과)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1,2,3,4,5,6,7,8,9,10", "1") }
        }
    }

    @Test
    fun `예외 테스트(반복 횟수 숫자 변환 불가)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,b,c", "a") }
        }
    }

    @Test
    fun `예외 테스트(차 이름 중복)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,a", "1") }
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
