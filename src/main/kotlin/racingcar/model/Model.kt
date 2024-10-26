package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Model {
    fun canMoveForward(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}