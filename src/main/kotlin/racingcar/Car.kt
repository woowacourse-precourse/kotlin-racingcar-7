package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(
    private val name: String,
) {
    private var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) > 3) position++
    }

    fun printResult(): String {
        return ""
    }

    fun getName(): String = name
    fun getPosition(): Int = position
}