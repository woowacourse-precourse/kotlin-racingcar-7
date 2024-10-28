package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차 이름 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
        assertThrows<IllegalArgumentException> {
            Car("일이삼사오육")
        }
    }

    @Test
    fun `앞으로 이동`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pibo")
                car.move()
                Assertions.assertEquals(car.goState, "-")
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `멈춤`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pibo")
                car.move()
                Assertions.assertEquals(car.goState, "")
            },
            STOP
        )
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}