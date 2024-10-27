package racingcar.control

import racingcar.utils.SettingValue

class OneStepForward {
    fun oneStepForward(): Boolean {
        val oneStepForward = SettingValue()
        return RandomNumberGenerator().randomNumberGenerator() >= oneStepForward.MINIMUM_NUMBER_TO_ONE_STEP_FORWARD
    }
}