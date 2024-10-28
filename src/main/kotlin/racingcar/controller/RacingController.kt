package racingcar.controller

import racingcar.model.Racing
import racingcar.utils.Validation
import racingcar.view.Input

class RacingController {
    fun playGame(){
        val carName = Input().getCars()
        val tryCount = Input().getCount()
        Racing().race(tryCount,Racing().readyToRace(carName))
    }
}