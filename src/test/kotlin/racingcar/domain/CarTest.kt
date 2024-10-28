package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차가 전진할 때 position이 증가한다`() {
        val car = Car("tama")
        val initialPosition = car.position

        car.move(true)
        assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    @Test
    fun `자동차가 전진하지 않을 때 position이 유지된다`() {
        val car = Car("tama")
        val initialPosition = car.position

        car.move(false)
        assertThat(car.position).isEqualTo(initialPosition)
    }
}