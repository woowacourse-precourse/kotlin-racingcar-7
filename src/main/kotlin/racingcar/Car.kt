package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var distance = 0
        private set

    fun moveForwardIfPossible() {
        if (shouldMove()) {
            distance++
        }
    }

    private fun shouldMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}