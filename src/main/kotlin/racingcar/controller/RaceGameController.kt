package racingcar.controller

import racingcar.view.RaceGameView

class RaceGameController(
    private val raceGameView: RaceGameView,
) {
    fun startRaceProcess() {
        val carNames: String = raceGameView.inputCarNames()
        val tryCount: Int = raceGameView.inputTryCount()
    }
}
