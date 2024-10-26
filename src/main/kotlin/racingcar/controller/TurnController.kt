package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.CarList

class TurnController(private val carList: CarList) {

    private fun getRandomValue(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun playTurn() {
        for (index in 0 until carList.getSize()) {
            val randomValue = getRandomValue()
            print(randomValue)
        }
        println()
    }

}