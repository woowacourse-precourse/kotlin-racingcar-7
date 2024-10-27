package racingcar.control

import racingcar.view.CountError

class CountValidator {

    fun countValidator(countInput: String): Int {

        if (countInput.isBlank()) {
            throw IllegalArgumentException(CountError().EMPTY_COUNT)
        }
        if (!countInput.contains(Regex("^[0-9]*$"))) {
            throw IllegalArgumentException(CountError().INCLUDED_STRING)
        }
        if (countInput.toInt() == 0) {
            throw IllegalArgumentException(CountError().ZERO_INPUT)
        }

        return countInput.toInt()
    }
}
