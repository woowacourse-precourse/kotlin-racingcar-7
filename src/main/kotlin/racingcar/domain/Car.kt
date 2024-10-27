package racingcar.domain

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun move() {
        position++
    }

    fun display(): String {
        return "$name : ${"-".repeat(position)}"
    }

}