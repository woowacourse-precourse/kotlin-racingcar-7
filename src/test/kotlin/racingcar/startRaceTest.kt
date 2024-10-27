package racingcar

import Model.Car
import Model.RandomMoveStrategy
import Model.startRace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StartRaceTest {
    @Test
    fun `주어진 라운드 수만큼 각 자동차 움직이기`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val rounds = 3
        val moveStrategy = RandomMoveStrategy()

        val progress = startRace(cars, rounds, moveStrategy)

        assertThat(progress).hasSize(rounds)
        assertThat(progress.last()).allMatch { it.contains("pobi") || it.contains("woni") }
    }

    @Test
    fun `라운드 수가 음수일 경우 예외 발생`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val rounds = -1
        val moveStrategy = RandomMoveStrategy()

        assertThrows<IllegalArgumentException> {
            startRace(cars, rounds, moveStrategy)
        }
    }
}
