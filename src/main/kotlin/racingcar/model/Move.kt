package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Move {
    fun move(infoOfCar: MutableMap<String, Int>): MutableMap<String, Int> {
        for ((name, move) in infoOfCar) {
            moveCar(infoOfCar, name, move, getRandomNumber())
        }
        return infoOfCar
    }

    private fun moveCar(
        infoOfCar: MutableMap<String, Int>,
        name: String,
        move: Int,
        randomNumber: Int,
    ): MutableMap<String, Int> {
        if (randomNumber >= 4) {
            infoOfCar[name] = move + 1
        }
        return infoOfCar
    }

    private fun getRandomNumber(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        return randomNumber
    }
}