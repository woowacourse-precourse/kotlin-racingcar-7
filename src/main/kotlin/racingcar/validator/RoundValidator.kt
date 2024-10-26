package racingcar.validator

import racingcar.exception.ExceptionMessage

private const val ROUND_LOWER_BOUND = 1
private const val ROUND_UPPER_BOUND = 10_000

object RoundValidator {

    fun validate(numberOfRoundInput: String): Int {
        require(isNumeric(numberOfRoundInput)) { ExceptionMessage.INVALID_NUMERIC_INPUT.message }
        require(isValidNumberOfRound(numberOfRoundInput)) { ExceptionMessage.INVALID_NUMBER_OF_ROUND.message }

        return numberOfRoundInput.toInt()
    }

    private fun isNumeric(input: String): Boolean {
        return input.all { it.isDigit() }
    }

    private fun isValidNumberOfRound(input: String): Boolean {
        return input.toInt() in ROUND_LOWER_BOUND..ROUND_UPPER_BOUND
    }

}
