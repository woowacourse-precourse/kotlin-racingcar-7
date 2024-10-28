package racingcar.service

import racingcar.domain.RacingCar
import racingcar.domain.RacingCars
import racingcar.view.OutputView

class RacingGame {
    fun start(
        input: List<String>,
        round: Int,
    ): List<String> {
        val cars = input.map { RacingCar(it) }
        var racingCars = RacingCars(cars)

        repeat(round) {
            racingCars = racingCars.move()

            OutputView.printMidResult(racingCars)
        }

        return racingCars.getWinners()
    }
}
