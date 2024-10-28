package racingcar.model

import org.junit.jupiter.api.Test
import racingcar.view.OutputViewImpl
import org.assertj.core.api.Assertions.assertThat

class RacingGameTest {

    @Test
    fun `승자를 찾는 기능이 동작하는지 테스트`() {
        val cars = listOf(Car("test1"), Car("test2"), Car("test3"))
        val attemptCount = AttemptCount(5)
        val game = RacingGame(cars, attemptCount)
        game.startRacing(OutputViewImpl())

        val names = cars.map { it.getName() }

        val winners = game.findWinners().split(", ")

        for (winner in winners) {
            assertThat(names).contains(winner)
        }
    }
}