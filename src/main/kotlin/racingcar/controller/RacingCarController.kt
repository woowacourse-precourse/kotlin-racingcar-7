package racingcar.controller

import racingcar.model.RacingCarModel
import racingcar.view.RacingCarView

class RacingCarController (
    private val model: RacingCarModel,
    private val view: RacingCarView
) {
    fun run() {
        val inputCarList = view.getCarName()
        val inputAttempts = view.getAttempts()
    }
}