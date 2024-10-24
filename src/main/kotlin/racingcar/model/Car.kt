package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(
    var location: Int = 0,
    var randomNumber: Int,
) {
    fun move() {
        randomNumber = Randoms.pickNumberInRange(0, 9)

        if (randomNumber >= 4) {
            location += 1
        }
    }

    fun getLocation(): Int {
        return location
    }
}