package racingcar.domain.numbergenerator

import camp.nextstep.edu.missionutils.Randoms

private const val NUMBER_LOWER_BOUND = 0
private const val NUMBER_UPPER_BOUND = 9

class RandomNumberGenerator : NumberGenerator {

    override fun generateNumber() = Randoms.pickNumberInRange(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND)

}
