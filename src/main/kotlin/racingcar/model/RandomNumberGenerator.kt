package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator: NumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
    }

    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 9
    }
}
