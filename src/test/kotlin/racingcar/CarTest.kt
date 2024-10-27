package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 전진 시 forwardCount 값 증가`() {
        val car = Car("carName")
        val beforeValue = car.forwardCount

        car.moveForwardAndStop(MOVING_FORWARD)
        val afterValue = car.forwardCount

        assertEquals((afterValue - beforeValue), 1)
    }

    @Test
    fun `자동차 멈춤 시 forwardCount 값 유지`() {
        val car = Car("carName")
        val beforeValue = car.forwardCount

        car.moveForwardAndStop(STOP)
        val afterValue = car.forwardCount

        assertEquals((afterValue - beforeValue), 0)
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
