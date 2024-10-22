package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RaceRandomGenerator : NumberGenerator {
    override fun generate() = Randoms.pickNumberInRange(0, 9)
}