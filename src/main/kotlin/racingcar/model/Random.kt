package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import java.util.Random

open class Random {
    open fun randomGenerator(): Boolean {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        return randomNum >= 4
    }
}