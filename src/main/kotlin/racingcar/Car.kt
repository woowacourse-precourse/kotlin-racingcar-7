package racingcar

class Car(val name: String) {
    var moves = 0
        private set

    fun moveForward(): Int {
        return ++moves
    }
}