package racingcar.validator

import racingcar.controller.CAR_NAME_DELIMITER
import racingcar.exception.ExceptionMessage
import racingcar.exception.RacingGameException

private const val CAR_NAME_MAX_SIZE = 5
private val BLANK_AND_TAB_REMOVE_REGEX = """[ \t]""".toRegex()
private const val BLANK_AND_TAB_REPLACEMENT = ""

object CarNameValidator {

    fun validate(input: String): String {
        val replacedInput = replaceBlankByInput(input)
        val candidateCarNames = convertValidateForm(replacedInput)

        if (!validateCarNameSize(candidateCarNames)) throw RacingGameException(ExceptionMessage.INVALID_CAR_NAME_SIZE)
        if (!validateDuplicateCarName(candidateCarNames)) throw RacingGameException(ExceptionMessage.DUPLICATED_CAR_NAME)

        return candidateCarNames.joinToString(separator = CAR_NAME_DELIMITER) { it }
    }

    private fun replaceBlankByInput(input: String): String {
        return input.replace(BLANK_AND_TAB_REMOVE_REGEX, BLANK_AND_TAB_REPLACEMENT)
    }

    private fun convertValidateForm(input: String): List<String> {
        return input.split(CAR_NAME_DELIMITER).toList()
    }

    private fun validateCarNameSize(input: List<String>): Boolean {
        return input.none { invalidCarNameSize(it) }
    }

    private fun invalidCarNameSize(carName: String) = carName.isEmpty() || carName.length > CAR_NAME_MAX_SIZE

    private fun validateDuplicateCarName(input: List<String>): Boolean {
        val duplicateChecker = hashSetOf(elements = input.toTypedArray())
        return duplicateChecker.size == input.size
    }

}

