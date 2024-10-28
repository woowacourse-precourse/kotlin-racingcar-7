package racingcar.model

class Car(private val name: String) {
    private var moveCount = 0
    fun getName(): String {
        return this.name
    }

    fun moveForward() {
        this.moveCount++
    }

    fun getMoveCount(): Int {
        return this.moveCount
    }
}