package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Dice {
    fun roll(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}