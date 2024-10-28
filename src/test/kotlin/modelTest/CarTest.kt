package modelTest

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Model.Car

private const val CANT_BE_LONGER_THAN_5 = " -> 자동차 이름은 5자 이하이어야 합니다."

class CarTest {
    @Test
    fun `자동차에 이름을 부여할 수 있다`() {
        assertSimpleTest {
            //given
            val nameOfCar = "hyun"

            //when
            val car = Car(nameOfCar)

            //then
            assertThat(car.name).isEqualTo(nameOfCar)
        }
    }

    @Test
    fun `자동차 이름은 5자 이하이어야 한다`() {
        assertSimpleTest {
            //given
            val nameOfCar = "This_is_more_longer_than_5"

            //when
            val error = assertThrows<IllegalArgumentException> { Car(nameOfCar) }

            //then
            assertThat(error.message).isEqualTo(nameOfCar + CANT_BE_LONGER_THAN_5)
        }
    }
}