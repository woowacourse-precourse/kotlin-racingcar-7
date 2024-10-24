package racingcar

class Car(val name: String, private var position: Int) {
    fun go() = position++
}