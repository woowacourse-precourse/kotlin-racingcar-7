package racingcar.control

import racingcar.message.CountException

class CountValidator {

    fun countValidator(countInput: String): Int {

        if (countInput.isBlank()) {
            throw IllegalArgumentException(CountException().EMPTY_COUNT)
        }
        if (!countInput.contains(Regex("^[0-9]*$"))) {
            throw IllegalArgumentException(CountException().INCLUDED_STRING)
        }
        if (countInput.toInt() == 0) {
            throw IllegalArgumentException(CountException().ZERO_INPUT)
        }

        return countInput.toInt()
    }
}
