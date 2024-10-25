package racingcar.domain

class Car(
    val carName: String,
    private val randomNumber: RandomNumber
) {

    var distance: String = INITIAL_DISTANCE_VALUE

    companion object {
        private const val INITIAL_DISTANCE_VALUE = ""
    }
}
