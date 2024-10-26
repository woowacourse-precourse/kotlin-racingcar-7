package racingcar

class Car(private val name: String) {
    private var position: Int = 0

    fun move() {}

    fun printResult(): String {
        return ""
    }

    fun getName(): String = name
    fun getPosition(): Int = position
}