package racingcar.validator

import racingcar.exception.ExceptionMessage
import racingcar.exception.RacingGameException

private const val ROUND_LOWER_BOUND = 1
private const val ROUND_UPPER_BOUND = 10_000

object RoundValidator {

    fun validate(numberOfRoundInput: String): Int {
        val numberOfRound =
            numberOfRoundInput.toIntOrNull() ?: throw RacingGameException(ExceptionMessage.INVALID_NUMERIC_INPUT)
        if (!isValidNumberOfRound(numberOfRound)) throw RacingGameException(ExceptionMessage.INVALID_NUMBER_OF_ROUND)

        return numberOfRound
    }

    private fun isValidNumberOfRound(numberOfRound: Int): Boolean {
        return numberOfRound in ROUND_LOWER_BOUND..ROUND_UPPER_BOUND
    }

}
