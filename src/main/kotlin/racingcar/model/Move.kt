package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Move {
    fun move(infoOfCar: MutableMap<String, Int>): MutableMap<String, Int> {
        for ((name, move) in infoOfCar) {
            getRandomNumber(infoOfCar, name, move)
        }
        return infoOfCar
    }

    private fun getRandomNumber(infoOfCar: MutableMap<String, Int>, name: String, move: Int): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            infoOfCar[name] = move + 1
        }
        return randomNumber
    }
}