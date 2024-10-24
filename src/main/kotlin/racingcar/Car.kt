package racingcar

class Car(val name: String) {
    var distance: Int = 0  // 이동 거리

    fun moveFoward(randomValue: Int) {
        if (randomValue >= 4) {
            distance++
        }
    }
}