package racingcar

import racingcar.constants.AttemptException

class Attempt private constructor(private val count: Int) {
    companion object {
        private const val MAX = Int.MAX_VALUE

        fun of(input: String): Attempt {
            val count = input.toIntOrNull() ?: throw IllegalArgumentException(AttemptException.NOT_NUMBER.message)
            require(count > 0) { AttemptException.MINIMUM.message }
            require(count <= MAX) { AttemptException.TOO_LARGE.message }
            return Attempt(count)
        }
    }

    fun getCount() = count
}
