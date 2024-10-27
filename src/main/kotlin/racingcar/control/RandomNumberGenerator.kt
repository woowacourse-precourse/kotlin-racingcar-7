package racingcar.control

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    fun randomNumberGenerator(): Int {
        val arrange = SettingValue()
        val randomNumberResult = Randoms.pickNumberInRange(arrange.STARTING_NUMBER,arrange.ENDING_NUMBER)
        return randomNumberResult
    }
}