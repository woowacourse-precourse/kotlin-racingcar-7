package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var prgress = 0
        private set

    fun moveToForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            prgress++
        }
    }

    fun getCurrentProgress(): String {
        return "-".repeat(prgress)
    }
}
