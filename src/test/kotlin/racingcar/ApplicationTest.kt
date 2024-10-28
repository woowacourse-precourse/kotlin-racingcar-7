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
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `경주할 자동차 이름이 중복일 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo,dudu,bobo", "1") }
        }
    }

    @Test
    fun `경주할 자동차 이름이 하나라도 5글자 초과일 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo,dududu", "1") }
        }
    }

    @Test
    fun `경주할 자동차 이름이 하나라도 공백이 포함되어 있을 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo,du du", "1") }
        }
    }

    @Test
    fun `경주할 자동차 이름이 하나라도 공백으로 이루어져 있을 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo,   ", "1") }
        }
    }

    @Test
    fun `경주 횟수가 0일 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo", "0") }
        }
    }

    @Test
    fun `경주 횟수가 실수형일 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo", "2.5") }
        }
    }

    @Test
    fun `경주 횟수가 음수일 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo", "-10") }
        }
    }

    @Test
    fun `경주 횟수가 숫자가 아닐 때 IllegalArgumentException 을 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("nana,bobo", "dudu") }
        }
    }

    @Test
    fun `랜덤한 값이 4이상일 경우 자동차 위치가 1(-) 증가한다`() {
        assertRandomNumberInRangeTest(
            {
                run("nana,bobo", "1")
                assertThat(output()).contains("nana : -", "bobo : ")
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `가장 많이 전진한 자동차가 우승한다`() {
        assertRandomNumberInRangeTest(
            {
                run("nana,bobo,dudu", "3")
                assertThat(output()).contains("nana : ---", "bobo : ", "dudu : --", "최종 우승자 : nana")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, MOVING_FORWARD,
        )
    }

    @Test
    fun `가장 많이 전진한 자동차가 여러 대일 경우 우승자는 여러 명이 된다`() {
        assertRandomNumberInRangeTest(
            {
                run("nana,bobo,dudu", "5")
                assertThat(output()).contains(
                    "nana : -----",
                    "bobo : -----",
                    "dudu : -----",
                    "최종 우승자 : nana, bobo, dudu"
                )
            }, MOVING_FORWARD
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
