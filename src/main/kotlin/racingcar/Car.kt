package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String) {
    var distance: Int = 0
    fun checkMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }

    fun display(): String {
        return "$name : ${GO.repeat(distance)}"

    }

    companion object {
        const val GO = "-"
    }
}