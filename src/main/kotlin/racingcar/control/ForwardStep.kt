package racingcar.control

import racingcar.utils.SettingValue

class ForwardStep {
    fun moveForward(): Boolean {
        val oneStepForward = SettingValue
        return RandomNumberGenerator().generateRandomNumber()>= oneStepForward.MINIMUM_NUMBER_TO_ONE_STEP_FORWARD
    }
}