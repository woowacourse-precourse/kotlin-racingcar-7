package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.CarList
import racingcar.view.ConsoleView

class TurnController(
    private val carList: CarList,
    private val consoleView: ConsoleView
) {

    private fun getRandomValue(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun addMoveCount(randomValue: Int, carList: CarList, index: Int) {
        if (randomValue >= 4) {
            carList.getCar(index).moveForward()
        }
    }

    fun playTurn() {
        for (index in 0 until carList.getSize()) {
            val randomValue = getRandomValue()
            addMoveCount(randomValue, carList, index)
            consoleView.printRaceProcess(carList, index)
        }
        consoleView.printTurnEnd()
    }

}