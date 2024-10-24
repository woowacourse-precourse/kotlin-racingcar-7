package racingcar.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {

    @Test
    fun `전진 기능 테스트`() {
        val car = Car("test")
        car.moveForward()
        car.moveForward()
        car.moveForward()

        assertThat(car.currentDistance).isEqualTo("---")
    }
}