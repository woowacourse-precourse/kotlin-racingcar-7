package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Cars

class RaceController {
    fun run() {
        val inputView = InputView()
        val outputView = OutputView()

        val carNames = inputView.readCarNames()
        val trialCount = inputView.readTrialCount()

        outputView.announceResultStart()

        val cars = Cars(carNames)
        repeat(trialCount) {
            cars.move()
        }
    }
}
