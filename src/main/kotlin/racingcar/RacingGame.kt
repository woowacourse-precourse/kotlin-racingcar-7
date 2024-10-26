package racingcar

import racingcar.domain.Car

class RacingGame {
    fun start(
        input: List<String>,
        round: Int,
    ): List<String> {
        val cars = input.map { Car(it) }
        var racingCars = RacingCars(cars)

        repeat(round) {
            racingCars = racingCars.move()

            OutputView.printMidResult(racingCars)
        }

        return racingCars.getWinners()
    }
}
