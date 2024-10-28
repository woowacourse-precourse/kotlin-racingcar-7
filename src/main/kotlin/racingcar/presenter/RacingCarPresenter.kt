package racingcar.presenter

import racingcar.model.AttemptCount
import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.OutputView

class RacingCarPresenter {

    fun createRacingCars(carNames: List<String>): List<Car> {
        val cars = carNames.map { name ->
            Car(name)
        }
        return cars
    }

    fun createAttemptCount(number: Int): AttemptCount {
        val attemptCount = AttemptCount(number)
        return attemptCount
    }

    fun startRacing(cars: List<Car>, attemptCount: AttemptCount, outputView: OutputView) {
        val game = RacingGame(cars, attemptCount)
        game.startRacing(outputView)
    }
}