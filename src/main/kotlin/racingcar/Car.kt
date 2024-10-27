package racingcar

class Car(val name: String) {
    var distance: Int = 0 // 이동 거리

    fun moveForward(randomValue: Int) {
        if (randomValue >= 4) {
            distance++
        }
    }
}