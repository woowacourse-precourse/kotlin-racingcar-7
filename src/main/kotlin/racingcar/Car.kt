package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {

    private var _goState: String = ""
    val goState: String get() = _goState

    init {
        checkValidate()
    }

    private fun checkValidate() {
        require(name.isNotEmpty() && name.length <= NAME_LIMIT) { WRONG_NAME_MESSAGE }
    }

    fun move() {
        val randomNumber = getRandomNumber()
        if (randomNumber >= RANDOM_STANDARD) go()
    }

    private fun go() {
        _goState += GO_STATE_SYMBOL
    }

    private fun getRandomNumber(): Int = Randoms.pickNumberInRange(RANDOMS_MIN_RANGE, RANDOMS_MAX_RANGE)

    companion object {
        private const val RANDOM_STANDARD = 4
        private const val NAME_LIMIT = 5
        private const val RANDOMS_MIN_RANGE = 0
        private const val RANDOMS_MAX_RANGE = 9
        private const val GO_STATE_SYMBOL = '-'
        private const val WRONG_NAME_MESSAGE = "자동차 이름은 1자 이상, 5자 이하로 입력해주세요."
    }
}