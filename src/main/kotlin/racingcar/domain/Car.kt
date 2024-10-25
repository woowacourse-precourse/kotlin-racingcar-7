package racingcar.domain

class Car(
    val carName: String,
    private val randomNumber: RandomNumber
) {

    var distance: String = INITIAL_DISTANCE_VALUE

    init {
        validateCarNameLength(carName)
    }

    private fun validateCarNameLength(carName: String) =
        require(carName.length <= MAX_CAR_NAME_LENGTH) { "자동차 이름은 다섯글자를 넘을 수 없습니다." }

    companion object {
        private const val INITIAL_DISTANCE_VALUE = ""
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
