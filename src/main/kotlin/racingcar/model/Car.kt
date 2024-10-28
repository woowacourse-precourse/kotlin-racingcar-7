package racingcar.model

class Car(private val name: String, private val move: CarMove) {
    private var position = 0

    fun move() {
        if (move.canMove()) {
            position++
        }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}