package racingcar

class InputValidator() {

    fun String.validateNameLength() {
        this.split(",").forEach {
            if (it.length > 5)
                throw IllegalArgumentException(
                    ErrorType.INVALID_NAME_OVER_5_LENGTH_INPUT.message
                )
        }
    }

    private fun String.isNumeric(): Boolean =
        this.all { it.isDigit() } || (this.startsWith("-") && this.drop(1).all { it.isDigit() })

    private fun String.isNegativeNumber(): Boolean =
        this.toInt() < 0
}