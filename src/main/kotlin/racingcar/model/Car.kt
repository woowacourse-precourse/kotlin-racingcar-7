package racingcar.model

class Car(val name : String) {
    var movedDistance : Int = 0
        private set

    fun move() {
        movedDistance++
    }
}