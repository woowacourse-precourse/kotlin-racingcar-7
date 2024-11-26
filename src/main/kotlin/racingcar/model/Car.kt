package racingcar.model

class Car(private val name: String, private var position: Int) {
    override fun toString(): String = name

    fun move(randomNum: Int) {
        if (randomNum in MOVE_CONDITION_START..MOVE_CONDITION_END) position++
    }

    fun getPosition() = position

    companion object {
        const val MOVE_CONDITION_START = 4
        const val MOVE_CONDITION_END = 9
    }
}