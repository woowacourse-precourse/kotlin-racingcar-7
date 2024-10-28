package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceTest {
    private val game = RacingGame()

    @Test
    fun `경주 테스트(우승자 1명)`() {
        val cars = listOf(
            Car("cola"),
            Car("cider"),
            Car("welch"),
        )
        val roundCounts = 5

        val randomNumbersFirst = listOf(1, 2, 3, 4, 5)
        val randomNumbersSecond = listOf(2, 3, 4, 5, 6)
        val randomNumbersThird = listOf(3, 4, 5, 6, 7)

        repeat(roundCounts) {
            cars[0].moving(randomNumbersFirst[it])
            cars[1].moving(randomNumbersSecond[it])
            cars[2].moving(randomNumbersThird[it])
        }

        val winnerList = List(1) { cars[2] }
        val winnerResult = game.determinedWinners(cars)

        assertEquals(winnerList, winnerResult)
    }
}