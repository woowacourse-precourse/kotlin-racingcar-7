package racingcar.controller

import racingcar.model.RacingCarModel
import racingcar.model.RacingCarPlay
import racingcar.view.RacingCarView

class RacingCarController {
    init {
        RacingCarView.printGetNameOfCar()
        val infoOfCar = getInfoOfCar()
        RacingCarView.printCountOfRacing()
        val countOfGame = getCount()
        playGame(infoOfCar, countOfGame)
    }

    private fun getInfoOfCar(): MutableMap<String, Int> {
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

    private fun printStatus(infoOfCar: MutableMap<String, Int>) {
        val play = RacingCarPlay()
        val presentInfo = play.playMatch(infoOfCar)
        for ((key, value) in presentInfo) {
            RacingCarView.printStatusOfName(key)
            RacingCarView.printStatusOfMove(value)
        }
        RacingCarView.printLineFeed()
    }

    private fun playGame(infoOfCar: MutableMap<String, Int>, countOfGame: Int) {
        RacingCarView.printResultMessage()
        for (i in 1..countOfGame) {
            printStatus(infoOfCar)
        }
        // 최종 우승자 출력 필요
    }
}