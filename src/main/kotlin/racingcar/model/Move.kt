package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Move {
    fun moveCar(
        infoOfCar: MutableMap<String, Int>,
        name: String,
        nowStep: Int,
        number: Int
    ): MutableMap<String, Int> {
        if (number >= 4) {
            infoOfCar[name] = nowStep + 1
        }
        return infoOfCar
    }
}