package racingcar.validator

import racingcar.exception.ExceptionMessage

object CarNameValidator {

    fun validate(input: String): String {
        val replacedInput = replaceBlankByInput(input)
        val candidateCarNames = convertValidateForm(replacedInput)

        require(validateCarNameSize(candidateCarNames)) { ExceptionMessage.INVALID_CAR_NAME_SIZE.message }
        require(validateDuplicateCarName(candidateCarNames)) { ExceptionMessage.DUPLICATED_CAR_NAME.message }

        return candidateCarNames.joinToString(separator = ",") { it }
    }

    private fun replaceBlankByInput(input: String): String {
        return input.replace("""[ \t]""".toRegex(), "")
    }

    private fun convertValidateForm(input: String): List<String> {
        return input.split(",").toList()
    }

    private fun validateCarNameSize(input: List<String>): Boolean {
        return input.none { it.isEmpty() || it.length > 5 }
    }

    private fun validateDuplicateCarName(input: List<String>): Boolean {
        val duplicateChecker = hashSetOf<String>()
        duplicateChecker.addAll(input)
        return duplicateChecker.size == input.size
    }

}

