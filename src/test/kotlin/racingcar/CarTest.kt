package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `4 미만 난수 이동 체크`() {
        val testCar = Car("pobi", 0)
        for (r in 0..3)
            testCar.move(r)
        assertThat(testCar.getPos()).isEqualTo(0)
    }

    @Test
    fun `4 이상 난수 이동 체크`() {
        val testCar = Car("pobi", 0)
        for (r in 4..9)
            testCar.move(r)
        assertThat(testCar.getPos()).isEqualTo(6)
    }
}