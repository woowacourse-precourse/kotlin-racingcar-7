package racingcar

class Car(val name: String, private var position: Int) {
    override fun toString(): String = name

    fun go() = position++

    fun getPos() = position
}