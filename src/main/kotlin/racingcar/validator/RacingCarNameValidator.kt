package racingcar.validator

import racingcar.constant.ErrorMessage
import racingcar.constant.GameSettings

object RacingCarNameValidator {
    fun validate(racingCarNames: List<String>): Boolean {
        return when {
            hasDuplicateNames(racingCarNames) -> throw IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NAMES)
            isNameEmpty(racingCarNames) -> throw IllegalArgumentException(ErrorMessage.IS_NAME_EMPTY)
            isOverMaxLength(racingCarNames) -> throw IllegalArgumentException(ErrorMessage.IS_OVER_MAX_LENGTH)
            else -> true
        }
    }

    private fun hasDuplicateNames(names: List<String>) = names.size != names.distinct().size

    private fun isNameEmpty(names: List<String>) = names.any { name -> name.isEmpty() }

    private fun isOverMaxLength(names: List<String>) = names.any { name -> name.length > GameSettings.MAX_LENGTH }
}