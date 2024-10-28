package racingcar.controller

import racingcar.view.InputView

class RaceController {
    fun run() {
        val inputView = InputView()
        val carNames = inputView.readCarNames()
        val trialCount = inputView.readTrialCount()
    }
}
