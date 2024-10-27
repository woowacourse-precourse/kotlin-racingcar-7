package racingcar.model

class Car(
    var score: Int = 0,
    var scoreSymbol: String = "",
) {
    fun move() {
        score += 1
    }

    fun updateScoreSymbol() {
        scoreSymbol = "-".repeat(score)
    }
}