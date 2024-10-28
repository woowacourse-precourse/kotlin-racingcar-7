package modelTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Model.Car

class CarTest {
    @Test
    fun `자동차에 이름을 부여할 수 있다`() {
        //given
        val nameOfCar = "hyun"

        //when
        val car = Car(nameOfCar)

        //then
        assertThat(car.name).isEqualTo(nameOfCar)
    }
}