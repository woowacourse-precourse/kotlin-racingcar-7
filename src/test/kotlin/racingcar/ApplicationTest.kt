package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
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
    fun `자동차 이름 공백 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `이동 횟수 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    @Test
    fun `무작위 값이 4 이상일 때 전진 테스트`() {
        val car = object : Car("pobi") {
            override fun getRandomNumber() = 4
        }
        car.move()
        assertEquals(1, car.position)
    }

    @Test
    fun `무작위 값이 4 미만일 때 멈춤 테스트`() {
        val car = object : Car("pobi") {
            override fun getRandomNumber() = 2
        }
        car.move()
        assertEquals(0, car.position)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
