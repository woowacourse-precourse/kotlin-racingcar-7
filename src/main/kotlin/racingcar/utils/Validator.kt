package racingcar.utils

import racingcar.enum.ValidationError.*
import racingcar.extensions.isDuplicationName
import racingcar.extensions.isPlayerLimitExceeded

object Validator {

    private fun validateDefaultError(input: String) {
        val error = when {
            input.isEmpty() -> EMPTY
            input.contains(" ") -> INCLUDED_GAP
            else -> return
        }

        throw IllegalArgumentException(error.message)
    }

    fun validateName(name: String) {
        validateDefaultError(name)
        val error = when {
            Regex("[^a-zA-Z0-9가-힣,]").containsMatchIn(name) -> INVALID_NAME
            name.isDuplicationName() -> DUPLICATION_NAME
            name.isPlayerLimitExceeded() -> EXCEEDED_PLAYER_LIMIT
            else -> return
        }

        throw IllegalArgumentException(error.message)
    }

    fun validateAttemptCount(count: String) {
        validateDefaultError(count)
        val error = when {
            Regex("^[1-9][0-9]*$").containsMatchIn(count).not() -> INVALID_ATTEMPT_COUNT
            count.toInt() > 10 -> EXCEEDED_ATTEMPT_COUNT
            else -> return
        }

        throw IllegalArgumentException(error.message)
    }
}