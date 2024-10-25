package racingcar.service

import racingcar.resources.Messages

class InputValidator {
    fun carNamesValidate(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT }

        val names = input.split(",")
        names.forEach { name ->
            require(name.length in 1..5) {
                Messages.ERROR_NAME_LENGTH
            }
        }
    }

    fun tryCountValidate(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT }

        val number = runCatching { input.toInt() }
            .getOrElse { throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE) }

        require(number > 0) { Messages.ERROR_NOT_POSITIVE }
    }

}