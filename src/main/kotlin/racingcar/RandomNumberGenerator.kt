package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}