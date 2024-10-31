package racingcar.model

class AttemptCount(private val number: Int) {

    init {
        require(number > 0)
    }

    fun getNumber(): Int = number
}

