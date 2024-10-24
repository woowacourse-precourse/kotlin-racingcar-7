package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Move {
    fun move(infoOfCar: MutableMap<String, Int>): MutableMap<String, Int> {
        for ((key, value) in infoOfCar) {
            val randomNumber = Randoms.pickNumberInRange(0,9)
            if (randomNumber >= 4) {
                infoOfCar[key] = value + 1
            }
        }
        return infoOfCar
    }
}