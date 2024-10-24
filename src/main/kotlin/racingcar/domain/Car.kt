package racingcar.domain

data class Car(
    val name: String,
    private var _distance: Int = 0
) {
    val distance: Int
        get() = _distance
    
    fun goOneStep(randomNumber: Int) {
        if (randomNumber >= 4) _distance++
    }
}
