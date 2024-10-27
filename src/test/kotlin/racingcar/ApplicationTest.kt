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
        }
    }

    @Test
    fun `입력 공백 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,woni") }
        }
    }

    @Test
    fun `시도 횟수 0회 이하 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni","0") }
        }
    }

    @Test
    fun `콤마 아닌 문자 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi.woni") }
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
