package racingcar.validator

object Validator {
    private val carNamePattern = Regex("^([^,]{1,5})(,[^,]{1,5})*$")

    fun validateCarNames(carNames: String) {
        if (!carNamePattern.matches(carNames)) {
            throw IllegalArgumentException()
        }
    }

    fun validateTryCount(tryCount: String) {
        try {
            val count = tryCount.toInt()
            checkNegative(count)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }

    private fun checkNegative(count: Int) {
        if (count < 0) {
            throw IllegalArgumentException()
        }
    }
}
