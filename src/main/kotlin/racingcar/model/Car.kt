package racingcar.model

class Car(
    var score: Int = 0,
) {
    fun move() {
        score += 1
    }
}