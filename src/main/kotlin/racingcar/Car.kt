package racingcar

class Car(val name: String) {
    var distance: Int = 0
        private set

    fun move(randomValue: Int) {
        if (randomValue >= 4) {
            distance++
        }
    }
}