package racingcar.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.presenter.RacingCarPresenter
import racingcar.view.OutputViewImpl

class RacingGameTest {

    @Test
    fun `승자를 찾는 기능이 동작하는지 테스트`() {
        val names = listOf("test1", "test2", "test3")
        val cars = names.map { Car(it) }
        val game = RacingGame(cars)

        RacingCarPresenter(OutputViewImpl()).startRacing(cars.map { it.getName() }, 5)

        val winners = game.findWinners().split(", ")

        for (winner in winners) {
            assertThat(names).contains(winner)
        }
    }
}