package racingcar.controller

import racingcar.model.RacingCarModel
import racingcar.view.RacingCarView

class RacingCarController {
    init {
        RacingCarView.printGetNameOfCar()
        val infoOfCar = getInfoOfCar()
        RacingCarView.printCountOfRacing()
        val countOfGame = getCount()
        playGame()
    }

    private fun getInfoOfCar(): Map<String, Int> {
        val model = RacingCarModel()
        val stringNameOfCar = RacingCarView.getNameOfCar()
        model.checkException(stringNameOfCar)
        val infoOfCar = model.splitString(stringNameOfCar)
        return infoOfCar
    }

    private fun getCount(): Int {
        val getCountOfGame = RacingCarView.getCountOfRacing()
        return getCountOfGame
    }

    private fun playGame() {

    }
}