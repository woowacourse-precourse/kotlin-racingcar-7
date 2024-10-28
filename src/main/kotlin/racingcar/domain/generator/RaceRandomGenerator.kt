package racingcar.domain.generator

import camp.nextstep.edu.missionutils.Randoms

class RaceRandomGenerator : NumberGenerator {
    override fun generate() = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }
}