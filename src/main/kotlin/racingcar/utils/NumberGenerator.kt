package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    
    fun generate() = Randoms.pickNumberInRange(0, 9)
}