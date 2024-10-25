package racingcar.domain.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차는 이동 할 수 있다`() {
        // given
        val car = Car("aloe")
        val expected = 1

        // when
        car.move()

        // then
        Assertions.assertEquals(expected, car.position)
    }

    @Test
    fun `자동차의 이름과 위치를 출력할 수 있다`() {
        // given
        val car = Car("tesla")
        car.move()
        val expected = "tesla : -"

        // when && then
        Assertions.assertEquals(expected, car.toString())
    }
}