package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car

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

    // 예외 테스트

    @Test
    fun `자동차 이름이 중복될 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `자동차 이름이 5자를 초과할 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("pobiwoni") }
        }
    }

    @Test
    fun `자동차 이름에 공백이 포함될 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("po bi") }
        }
    }

    @Test
    fun `자동차 이름이 소문자 영어가 아닐 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("Pobi1") }
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아닐 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    @Test
    fun `시도 횟수가 0 이하일 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `시도 횟수가 너무 클 때 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", (Int.MAX_VALUE + 1L).toString()) }
        }
    }

    // 기능 테스트

    @Test
    fun `자동차 전진 기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "5")
                assertThat(output()).contains("pobi : -")
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `최종 우승자 출력 기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "5")
                assertThat(output()).contains("최종 우승자 : ")
            }, MOVING_FORWARD, STOP
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
