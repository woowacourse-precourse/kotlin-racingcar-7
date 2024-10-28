package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `우승자 한명 선정`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `공동 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -",

                    "pobi : --",
                    "woni : -",
                    "jun : --",

                    "pobi : ---",
                    "woni : --",
                    "jun : ---",

                    "pobi : ----",
                    "woni : ---",
                    "jun : ----",

                    "pobi : -----",
                    "woni : ----",
                    "jun : -----",

                    "최종 우승자 : pobi, jun"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `전진 하지 않는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("run,geun", "1")
                assertThat(output()).contains("run : ", "geun : ", "최종 우승자 : run, geun")
            },
            STOP
        )
    }

    @Test
    fun `3명 공동 우승`() {
        assertRandomNumberInRangeTest(
            {
                run("run,geun,ready", "1")
                assertThat(output()).contains("run : -", "geun : -", "ready : -", "최종 우승자 : run, geun, ready")
            },
            MOVING_FORWARD
        )
    }

    // 이름 예외
    @Test
    fun `이름 길이 초과 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이름 영역 정수 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("ru1n, geu2n", "1") }
        }
    }
    @Test
    fun `이름 영역 특수기호 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("run!, geun", "1") }
        }
    }
    @Test
    fun `이름 영역 빈 문자열 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }
    @Test
    fun `이름 영역 중간 빈문자열 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("run,,geun", "1") }
        }
    }
    @Test
    fun `이름 영역 쉽표 끝 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("run,geun,", "1") }
        }
    }
    // 시도 횟수 예외
    @Test
    fun `음수 입력 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("run,geun,", "-1") }
        }
    }
    @Test
    fun `실수 입력 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("run,geun,", "3.1") }
        }
    }
    @Test
    fun `오버플로우 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("run,geun,", "2147483648") }
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
