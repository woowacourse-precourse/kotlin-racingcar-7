package racingcar

data class Car(
    val name: String,
    var distance: Int = 0
) {
    fun increaseDistance(d: Int) {
        distance += d
    }

    override fun toString(): String = "${name} : ${"-".repeat(distance)}"
}
