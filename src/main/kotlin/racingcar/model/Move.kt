package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Move {
    fun moveCar(
        infoOfCar: MutableMap<String, Int>,
        name: String,
        move: Int,
        number: Int,
    ): MutableMap<String, Int> {
        if (number >= 4) {
            infoOfCar[name] = move + 1
        }
        return infoOfCar
    }

    fun getRandomNumber(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        return randomNumber
    }
}