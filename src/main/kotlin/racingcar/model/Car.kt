package racingcar.model

data class Car(
    private var score: Int = 0,
    private var randomNumber: Int = 0,
) {
    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            score += 1
        }
    }

    fun getScore(): Int {
        return score
    }
}