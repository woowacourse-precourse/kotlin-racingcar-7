package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingCar

class RacingCarTest {

    @Test
    fun `자동차가 이동할 때 위치가 증가하는지 테스트`() {
        val car = Car("pobi")
        car.move()

        assertEquals(1, car.position)
    }

    @Test
    fun `최종 우승자 찾기 테스트`() {
        val car1 = Car("pobi")
        val car2 = Car("jun")
        val car3 = Car("woni")
        val cars = listOf(car1, car2, car3)
        val racingCar = RacingCar(cars)

        val round = 5

        repeat(round) {
            racingCar.playRound()
        }

        val winners = racingCar.findWinners()
        val maxPosition = cars.maxOf { it.position }
        assertTrue(winners.all { it.position == maxPosition })
        assertTrue(winners.isNotEmpty())
    }

}