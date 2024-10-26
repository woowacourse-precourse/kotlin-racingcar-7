package racingcar.model

data class RacingCar(
    val carName: String,
    val forwardCount: Int,
) {
    override fun toString(): String = "$carName : ${"-".repeat(forwardCount)}"
}
