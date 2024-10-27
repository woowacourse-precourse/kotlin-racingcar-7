package racingcar

import Model.Car
import Model.findWinner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FindWinnerTest {
    @Test
    fun `가장 멀리 이동한 자동차가 우승자`() {
        val car1 = Car("pobi").apply { move(true); move(true) }
        val car2 = Car("woni").apply { move(true) }
        val cars = listOf(car1, car2)

        val winners = findWinner(cars)

        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `동일한 거리를 이동한 경우 공동 우승자가 된다`() {
        val car1 = Car("pobi").apply { move(true) }
        val car2 = Car("woni").apply { move(true) }
        val cars = listOf(car1, car2)

        val winners = findWinner(cars)

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni")
    }
}
