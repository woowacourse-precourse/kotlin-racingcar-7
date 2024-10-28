package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class RacingCar(
    val carName: String,
    var forwardCount: Int = 0,
) {
    fun moveForward() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            this.forwardCount += 1
        }
    }

    override fun toString(): String = "$carName : ${"-".repeat(forwardCount)}"
}
