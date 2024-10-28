package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 이동 테스트`() {
        val car = Car("pobi")
        car.move()
        assertThat(car.position).isEqualTo(1)
    }
}
