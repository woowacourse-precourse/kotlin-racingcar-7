package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Model(val name: String) {
    var moveCount = 0

    fun canMoveForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun moveCountUp() {
        if (canMoveForward()) moveCount++
    }

}