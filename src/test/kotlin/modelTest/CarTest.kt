package modelTest

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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

    @CsvSource("0, 0", "4, 1", "9, 1")
    @ParameterizedTest
    fun `무작위 값이 4 이상인 경우 전진하고 아니면 멈춰있는다`(randomNumber: Int, expectedPosition: Int) {
        assertRandomNumberInRangeTest(
            {
                //given
                val car = Car("hyun")

                //when
                car.moveForward(randomNumber)

                //then
                assertThat(car.position).isEqualTo(expectedPosition)

        },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `자동차는 본인의 위치를 가질 수 있다`() {
        assertRandomNumberInRangeTest(
            {
                //given
                val car = Car("hyun")
                val moveCounts = Randoms.pickNumberInRange(1, Int.MAX_VALUE)

                //when
                repeat(moveCounts) {
                    car.moveForward(MOVING_FORWARD)
                }

                //then
                assertThat(car.position).isEqualTo(moveCounts)
            },
            MOVING_FORWARD, STOP
        )
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP: Int = 3
    }
}