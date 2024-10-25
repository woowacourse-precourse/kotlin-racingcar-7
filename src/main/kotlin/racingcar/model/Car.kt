package racingcar.model

class Car(
    var score: Int = 0,
    private var randomNumber: Int = 0,
) {
    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            score += 1
        }
    }
}