package racingcar.model

data class Car(
    val name: String,
    var moving: Int = 0
) {
    fun move(value: Int) {
        if (value >= 4) moving++
    }
}