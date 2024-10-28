package racingcar.util

object Validator {
    private const val MIN_ATTEMPT = 1
    private const val MIN_CAR_COUNT = 2
    private const val MAX_CAR_LENGTH = 5

    fun validateInput(input: List<String>) {
        validateCount(input)
        validateDuplicate(input)
        input.forEach {
            validateLength(it)
            validateNull(it)
        }
    }

    fun validateAttempt(input: String) {
        validateAttemptNumber(input)
        validateAttemptValue(input)
    }

    private fun validateCount(input: List<String>) {
        require(input.size >= MIN_CAR_COUNT) {
            ErrorMessage.COUNT_ERROR.getMessage()
        }
    }

    private fun validateDuplicate(input: List<String>) {
        require(input.distinct().size == input.size) {
            ErrorMessage.DUPLICATE_ERROR.getMessage()
        }
    }

    private fun validateLength(input: String) {
        require(input.length <= MAX_CAR_LENGTH) {
            ErrorMessage.LENGTH_ERROR.getMessage()
        }
    }

    private fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.INPUT_ERROR.getMessage()
        }
    }

    private fun validateAttemptNumber(input: String) {
        require(input.all { it.isDigit() }) {
            ErrorMessage.ATTEMPTS_ERROR.getMessage()
        }
    }

    private fun validateAttemptValue(input: String) {
        require(input.toInt() >= MIN_ATTEMPT) {
            ErrorMessage.ATTEMPTS_VALUE_ERROR.getMessage()
        }
    }
}
