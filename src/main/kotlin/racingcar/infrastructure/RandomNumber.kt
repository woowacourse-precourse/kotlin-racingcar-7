package racingcar.infrastructure

import camp.nextstep.edu.missionutils.Randoms

object RandomNumber {
    fun pick(): Int {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)
    }
    private const val START_NUMBER: Int = 0
    private const val END_NUMBER: Int = 9
}