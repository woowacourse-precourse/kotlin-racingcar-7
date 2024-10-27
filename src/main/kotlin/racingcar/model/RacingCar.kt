package racingcar.model

data class RacingCar(
    val carName: String = "",
    var location: Int = 0
) {
    fun onMoveCar() {
        location++
    }
}
