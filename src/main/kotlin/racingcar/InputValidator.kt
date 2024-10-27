package racingcar

class InputValidator() {

    fun validateInput(nameInput: String, countInput: String) {
        nameInput.validateNameLength()
        countInput.validateCountInput()
    }

    fun String.validateNameLength() {
        this.split(",").forEach {
            if (it.length > MAX_LENGTH_CONDITION)
                throw IllegalArgumentException(
                    ErrorType.INVALID_NAME_OVER_5_LENGTH_INPUT.message
                )
        }
    }

    fun String.validateCountInput() {
        if (!(this.isNumeric()))
            throw IllegalArgumentException(ErrorType.INVALID_COUNT_NOT_NUMBER_INPUT.message)
        if (this.isNegativeNumber())
            throw IllegalArgumentException(ErrorType.INVALID_COUNT_NEGATIVE_INPUT.message)
        if (isDecimalNumber())
            throw IllegalArgumentException(ErrorType.INVALID_COUNT_NOT_DIGIT_INPUT.message)
    }

    private fun String.isNumeric(): Boolean =
        this.all { it.isDigit() } || (this.startsWith("-") && this.drop(1).all { it.isDigit() })

    private fun String.isNegativeNumber(): Boolean =
        this.toInt() < 0

    private fun String.isDecimalNumber(): Boolean =
        this.toDouble() != this.toInt().toDouble()

    companion object {
        const val MAX_LENGTH_CONDITION = 5
    }
}