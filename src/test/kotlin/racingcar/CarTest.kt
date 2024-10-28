package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `무작위값이 4이상 일 때_자동차전진`() {
        val car = Car("레드불", 0)
        val randomNumber = 5
        car.move(randomNumber)

        assertEquals(car.position, 1)
    }

    @Test
    fun `무작위값이 4미만 일 때_자동차멈춤`() {
        val car = Car("레드불", 0)
        val randomNumber = 3
        car.move(randomNumber)

        assertEquals(car.position, 0)
    }
}