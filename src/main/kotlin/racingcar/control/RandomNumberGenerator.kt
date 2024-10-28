package racingcar.control

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.SettingValue

class RandomNumberGenerator {
    fun generateRandomNumber(): Int {
        val arrange = SettingValue
        val randomNumberResult = Randoms.pickNumberInRange(arrange.STARTING_NUMBER, arrange.ENDING_NUMBER)
        return randomNumberResult
    }
}