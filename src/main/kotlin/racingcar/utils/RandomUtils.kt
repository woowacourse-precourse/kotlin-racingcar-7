package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object RandomUtils {
    fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}
