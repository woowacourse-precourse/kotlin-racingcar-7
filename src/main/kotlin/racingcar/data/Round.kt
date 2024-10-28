package racingcar.data

class Round(
    val count: String
) {
    init {
        require(count.toIntOrNull() != null)
        require(count.all { it.isDigit() })
        require(count.toInt() >= MINIMUM_ROUND_COUNT)
    }

    companion object {
        private const val MINIMUM_ROUND_COUNT = 1
        fun Round.toInt() = count.toInt()
    }
}