package racingcar.controller

import racingcar.view.InputView
import racingcar.model.Cars

class RaceController {
    fun run() {
        val inputView = InputView()
        val carNames = inputView.readCarNames()
        val trialCount = inputView.readTrialCount()

        val cars = Cars(carNames)
    }
}
