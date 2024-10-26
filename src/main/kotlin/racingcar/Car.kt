package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(nameInput: String) {
    val name = nameInput
    private var position: Int = 0

    fun carMove() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            position++
        }
        println("$name : " + "-".repeat(position))
    }

    fun getPosition(): Int {
        return position
    }
}