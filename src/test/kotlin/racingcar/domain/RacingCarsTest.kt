package racingcar.domain

import org.junit.jupiter.api.Test

class RacingCarsTest {
    @Test
    fun `move 정상 테스트`() {
        // given
        val cars = listOf(RacingCar("pobi"), RacingCar("woni"))
        val racingCars = RacingCars(cars)

        // when
        val movedRacingCars = racingCars.move()

        // then
        movedRacingCars.racingCars.forEach {
            println(it)
        }
    }

    @Test
    fun `getWinners 정상 테스트`() {
        // given
        val cars = listOf(RacingCar("pobi"), RacingCar("woni"))
        val racingCars = RacingCars(cars)

        // when
        val winners = racingCars.getWinners()

        // then
        winners.forEach {
            println(it)
        }
    }
}
