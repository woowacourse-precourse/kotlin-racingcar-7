package racingcar.control

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    fun randomNumberGenerator(): Int {
        val arrange = SettingValue()
        val randomNumberResult = Randoms.pickNumberInRange(arrange.startNumber,arrange.endNumber)
        return randomNumberResult
    }
}