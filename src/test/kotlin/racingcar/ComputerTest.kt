package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ComputerTest {
    private val game = RacingGame()
    private val computer = Computer()

    @Test
    fun `우승자 출력 메시지 테스트`() {
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

        val winnerResult = game.determinedWinners(cars)
        assertEquals("최종 우승자 : welch", computer.makeWinnerMessage(winnerResult))
    }
}