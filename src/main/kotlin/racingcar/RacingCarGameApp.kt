package racingcar

import racingcar.presenter.RacingCarPresenter
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarGameApp(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingCarPresenter: RacingCarPresenter
) {

    fun run() {
        val carNames = inputView.readNames()
        val cars = racingCarPresenter.createRacingCars(carNames)

        val number = inputView.readAttemptCount()
        val attemptCount = racingCarPresenter.createAttemptCount(number)
        outputView.printNewLine()

        racingCarPresenter.startRacing(cars, attemptCount, outputView)
    }
}