package racingcar.view

import racingcar.constants.Constants.COLON
import racingcar.constants.Constants.RESULT_MSG
import racingcar.constants.Constants.WINNERS_MSG
import racingcar.model.Car

class Output {
    fun resultMsg(carList: List<Car>, tryCount: Int) {
        println(RESULT_MSG)
        for (j in 0 until tryCount) {
            carList.forEach { car ->
                println(car.carName + COLON + car.moves.take(j + 1).joinToString(""))
            }
            println()
        }
    }

    fun winnerMsg(winnerList: List<String>) {
        val winners = winnerList.joinToString(", ")
        println(WINNERS_MSG + winners)
    }
}
