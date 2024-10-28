package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    companion object {
        const val MOVE_THRESHOLD = 4
        const val MAX_RANDOM_NUMBER = 9
        const val MIN_RANDOM_NUMBER = 0
    }

    private var position = 0

    fun getName() = name
    fun getPosition() = position

    fun moveForward() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD) {
            position++
        }
    }

    fun getStatus() = "$name : ${"-".repeat(position)}"
}
