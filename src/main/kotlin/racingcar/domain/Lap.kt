package racingcar.domain

class Lap(
    private val stringLapCount: String
) {

    val count: Int

    init {
        count = parserLapCount().also { validateLapCountPositive(it) }
    }

    private fun parserLapCount() =
        stringLapCount.toIntOrNull() ?: throw IllegalArgumentException(LAP_COUNT_NUMBER_ERROR_MESSAGE)

    private fun validateLapCountPositive(lapCount: Int) =
        require(lapCount >= MIN_LAP_COUNT) { LAP_COUNT_POSITIVE_ERROR_MESSAGE }

    companion object {
        private const val MIN_LAP_COUNT = 1
        private const val LAP_COUNT_NUMBER_ERROR_MESSAGE = "랩 카운트는 숫자를 입력해야 합니다."
        private const val LAP_COUNT_POSITIVE_ERROR_MESSAGE = "랩 카운트는 1회 이상 입력해야합니다."
    }

}
