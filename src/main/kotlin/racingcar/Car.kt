package racingcar

class Car(val name: String) {

    private var _goState: String = ""
    val goState: String get() = _goState

    init {
        checkValidate()
    }

    private fun checkValidate() {
        require(name.length <= NAME_LIMIT) { WRONG_NAME_MESSAGE }
    }

    companion object {
        private const val NAME_LIMIT = 5
        private const val WRONG_NAME_MESSAGE = "자동차 이름은 5자 이하만 가능합니다."
    }
}