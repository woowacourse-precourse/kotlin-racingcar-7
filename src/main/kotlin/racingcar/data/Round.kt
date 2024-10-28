package racingcar.data

class Round(
    val count: String
) {
    init {
        require(count.toIntOrNull() != null)
        require(count.all { it.isDigit() })
        require(count.toInt() in MINIMUM_ROUND_COUNT .. MAXIMUM_ROUND_COUNT)
    }

    companion object {
        private const val MINIMUM_ROUND_COUNT = 1
        private const val MAXIMUM_ROUND_COUNT = 20
        fun Round.convertRoundCountToInt() = count.toInt()
    }
}