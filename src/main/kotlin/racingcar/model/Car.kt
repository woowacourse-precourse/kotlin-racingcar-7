package racingcar.model

class Car(val name: String, private val move: CarMove) {
    var position = 0

    fun move() {
        if (move.canMove()) {
            position++
        }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}