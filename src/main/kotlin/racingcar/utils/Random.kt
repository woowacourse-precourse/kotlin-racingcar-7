package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object Random {
    private const val MIN_NUMBER = 0
    private const val MAX_NUMBER = 9

    fun pick() = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
}