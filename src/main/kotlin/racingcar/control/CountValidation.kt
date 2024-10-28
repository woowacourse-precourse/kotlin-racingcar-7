package racingcar.control

import racingcar.message.InvalidCountException

class CountValidation {
    fun validateCount(countInput: String): Int {
        if (countInput.isBlank()) {
            throw IllegalArgumentException(InvalidCountException.EMPTY_COUNT)
        }
        if (!countInput.contains(Regex("^[0-9]*$"))) {
            throw IllegalArgumentException(InvalidCountException.INCLUDED_STRING)
        }
        if (countInput.toInt() == 0) {
            throw IllegalArgumentException(InvalidCountException.ZERO_INPUT)
        }
        return countInput.toInt()
    }
}
