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
    fun `예외 테스트 - 자동차 이름이 5자를 초과한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,verylongname,loopy") }
        }
    }

    @Test
    fun `예외 테스트 - 자동차 이름에 공백 포함`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,lo opy,jun") }
        }
    }

    @Test
    fun `예외 테스트 - 자동차 이름이 빈 문자열인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ,loopy,jun") }
        }
    }

    @Test
    fun `예외 테스트 - 자동차 이름 중복`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi,loopy") }
        }
    }

    @Test
    fun `예외 테스트 - 시도 횟수가 0인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `예외 테스트 - 시도 횟수가 음수인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `예외 테스트 - 시도 횟수가 숫자가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
        }
    }

    @Test
    fun `기능 테스트 - 자동차 전진 조건 충족`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : -",
                    "jun : "
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `기능 테스트 - 전진 차수별 결과 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains(
                    "pobi : --",
                    "woni : -",
                    "jun : "
                )
            },
            MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `기능 테스트 - 단독 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : ",
                    "최종 우승자 : pobi"
                )
            },
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `기능 테스트 - 공동 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : -",
                    "jun : ",
                    "최종 우승자 : pobi, woni"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
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
