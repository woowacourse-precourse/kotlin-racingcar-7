package racingcar

import camp.nextstep.edu.missionutils.Randoms
class Car(private val name: String) {
    private var position = 0

    fun getName() = name
    fun getPosition() = position

    fun moveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
    fun getStatus() = "$name : ${"-".repeat(position)}"
}
