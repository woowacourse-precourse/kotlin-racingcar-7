package racingcar

class Car(val name: String, private var position: Int) {
    override fun toString(): String = name

    fun move(randomNum: Int) {
        if (randomNum in 4..9) position++
    }

    fun getPos() = position
}