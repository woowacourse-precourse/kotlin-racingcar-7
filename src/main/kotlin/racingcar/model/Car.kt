package racingcar.model

class Car(val name: String) {
    private var position = 0

    fun carMove() {
        position++
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}