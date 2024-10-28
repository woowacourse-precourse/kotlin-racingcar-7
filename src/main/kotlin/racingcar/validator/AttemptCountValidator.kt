package racingcar.validator

import racingcar.constant.ErrorMessage
import racingcar.constant.GameSettings

object AttemptCountValidator {
    fun validate(attemptCount: String): Boolean  {
        return when {
            isNonNumber(attemptCount) -> throw IllegalArgumentException(ErrorMessage.IS_NON_NUMBER)
            isNonPositiveNumber(attemptCount) -> throw IllegalArgumentException(ErrorMessage.IS_NON_POSITIVE_NUMBER)
            else -> true
        }
    }

    private fun isNonNumber(input: String) = input.toIntOrNull() == null

    private fun isNonPositiveNumber(input: String) = input.toInt() <= GameSettings.NON_POSITIVE_STANDARD
}