package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RaceRandomGenerator : NumberGenerator {
    override fun generate() = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER)

    companion object{
        private const val RANDOM_MIN_NUMBER = 0
        private const val RANDOM_MAX_NUMBER = 9
    }
}