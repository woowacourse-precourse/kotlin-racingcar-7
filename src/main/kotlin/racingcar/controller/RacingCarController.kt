package racingcar.controller

import racingcar.model.RacingCarException
import racingcar.model.RacingCarModel
import racingcar.view.RacingCarView

class RacingCarController {
    init {
        RacingCarView.printGetNameOfCar()
        controller()
    }

    private fun controller(){
        val model = RacingCarModel()
        val stringNameOfCar = RacingCarView.getNameOfCar()
        model.checkException(stringNameOfCar)
    }
}