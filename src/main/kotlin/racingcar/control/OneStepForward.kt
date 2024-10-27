package racingcar.control

class OneStepForward {
    fun oneStepForward(): Boolean {
        val oneStepForward = SettingValue()
        return RandomNumberGenerator().randomNumberGenerator()>=oneStepForward.minimumNumberToMoveForward
    }
}