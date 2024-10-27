package racingcar

import Model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `자동차 이름 5자 이하 - 정상 생성`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차 이름 5자 초과 - 예외 처리`() {
        assertThrows<IllegalArgumentException> { Car("toolongname") }
    }

    @Test
    fun `move 호출 시 canMove가 true이면 position이 1 증가`() {
        val car = Car("woni")
        car.move(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `move 호출 시 canMove가 false이면 position이 증가하지 않음`() {
        val car = Car("woni")
        car.move(false)
        assertThat(car.position).isEqualTo(0)
    }
}
