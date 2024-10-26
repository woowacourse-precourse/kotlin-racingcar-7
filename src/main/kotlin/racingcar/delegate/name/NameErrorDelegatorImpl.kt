package racingcar.delegate.name

import racingcar.constans.Constants.REGEX_FOR_INVALID_SEPARATORS
import racingcar.constans.NamingError.errorMessageForDuplicatedName
import racingcar.constans.NamingError.errorMessageForEmptyInput
import racingcar.constans.NamingError.errorMessageForEmptyName
import racingcar.constans.NamingError.errorMessageForInvalidNameFormat
import racingcar.constans.NamingError.errorMessageForInvalidPlayerCount
import racingcar.constans.NamingError.errorMessageForInvalidSeparator

class NameErrorDelegatorImpl : NameErrorDelegator {
    override fun checkInputIsEmpty(userInput: String) {
        if (userInput.trim().isEmpty()) {
            throw IllegalArgumentException(errorMessageForEmptyInput)
        }
    }

    override fun checkForInvalidSeparator(userNames: List<String>) {
        val isInvalidSeparator = Regex(REGEX_FOR_INVALID_SEPARATORS).matches(userNames[0])
        if (userNames.size == 1 && isInvalidSeparator.not()) {
            throw IllegalArgumentException(errorMessageForInvalidSeparator)
        }
    }

    override fun checkForInvalidNameFormat(userNames: List<String>) {
        userNames.map {
            if (Regex(REGEX_FOR_INVALID_SEPARATORS).matches(it).not()) {
                throw IllegalArgumentException(errorMessageForInvalidNameFormat)
            }
        }
    }

    override fun checkForEmptyName(userNames: List<String>) {
        if (userNames.any { it.isEmpty() }) {
            throw IllegalArgumentException(errorMessageForEmptyName)
        }
    }

    override fun checkForInvalidPlayerCount(userNames: List<String>) {
        if (userNames.size < 2) {
            throw IllegalArgumentException(errorMessageForInvalidPlayerCount)
        }
    }

    override fun checkForDuplicateName(userNames: Map<String, Int>) {
        if (userNames.count { it.value > 1 } > 0) {
            throw IllegalArgumentException(errorMessageForDuplicatedName)
        }
    }
}