package racingcar

import org.junit.jupiter.api.Test
import racingcar.domain.Car

class RacingCarsTest {
    @Test
    fun `move 정상 테스트`() {
        // given
        val cars = listOf(Car("pobi"), Car("woni"))
        val racingCars = RacingCars(cars)

        // when
        val movedRacingCars = racingCars.move()

        // then
        movedRacingCars.cars.forEach {
            println(it)
        }
    }

    @Test
    fun `getWinners 정상 테스트`() {
        // given
        val cars = listOf(Car("pobi"), Car("woni"))
        val racingCars = RacingCars(cars)

        // when
        val winners = racingCars.getWinners()

        // then
        winners.forEach {
            println(it)
        }
    }
}
