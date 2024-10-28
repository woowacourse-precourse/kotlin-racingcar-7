package racingcar.Model

import camp.nextstep.edu.missionutils.Randoms

private const val MIN_NUMBER = 0
private const val MAX_NUMBER = 9

fun interface RandomNumberGenerator {
    fun generateRandomNumber(): Int
}

object RandomNumber : RandomNumberGenerator {
    override fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }
}