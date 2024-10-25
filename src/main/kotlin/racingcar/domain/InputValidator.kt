package racingcar.domain

import racingcar.resources.Messages

class InputValidator {
    fun carNamesValidate(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT }
        val names = input.split(",")
        names.forEach { name ->
            require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH }
            require(name == name.trim()) { Messages.ERROR_BLANK_BOTH_END }
        }
        require(names.size == names.distinct().size) { Messages.ERROR_DUPLICATE_NAME }
    }

    fun tryCountValidate(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT }
        require(input.length < 9) { Messages.ERROR_OVERSIZE_TRY_COUNT }
        val number = runCatching { input.toInt() }
            .getOrElse { throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE) }
        require(number > 0) { Messages.ERROR_NOT_POSITIVE }
    }
}