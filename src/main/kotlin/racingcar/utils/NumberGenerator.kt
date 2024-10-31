package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {

    private const val MIN_NUMBER = 0
    private const val MAX_NUMBER = 9
    
    fun generate() = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
}