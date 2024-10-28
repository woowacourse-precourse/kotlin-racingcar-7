package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RefereeTest {
    private val referee = Referee()

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 1대인 경우 유일한 우승자가 된다.")
    fun single_winner_test() {
        val cars = listOf(
            Car("Car1", 3),
            Car("Car2", 2),
            Car("Car1", 1)
        )

        val winners = referee.getWinners(cars)

        assertEquals(listOf("Car1"), winners)
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러 대인 경우 공동 우승자가 된다.")
    fun multiple_winners_test() {
        val cars = listOf(
            Car("Car1", 3),
            Car("Car2", 3),
            Car("Car1", 1)
        )

        val winners = referee.getWinners(cars)

        assertEquals(listOf("Car1", "Car2"), winners)
    }

    @Test
    @DisplayName("모든 자동차의 위치가 0인 경우 모두 우승자가 된다.")
    fun every_winners_test() {
        val cars = listOf(
            Car("Car1", 0),
            Car("Car2", 0),
            Car("Car3", 0)
        )

        val winners = referee.getWinners(cars)

        assertEquals(listOf("Car1", "Car2", "Car3"), winners)
    }
}
