package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomGenerator {
    fun generate(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}