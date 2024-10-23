package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(
    val name: String,
    var distance: Int = 0
) {
    fun getNameWithIndicator(): String {
        return "$name : ${getDistanceIndicator()}"
    }

    private fun getDistanceIndicator(): String {
        return "-".repeat(distance)
    }

    fun randomMove() {
        val randomVal = Randoms.pickNumberInRange(0, 9)
        if (randomVal >= 4) {
            distance += 1
        }
    }
}