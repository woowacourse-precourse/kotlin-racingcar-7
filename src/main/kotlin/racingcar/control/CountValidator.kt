package racingcar.control

import racingcar.view.CountError

class CountValidator {

    fun countValidator(countInput: String): Int {

        if (countInput.isBlank()) {
            throw IllegalArgumentException(CountError().countBlank)
        }
        if (!countInput.contains(Regex("^[0-9]*$"))) {
            throw IllegalArgumentException(CountError().countIncludeString)
        }

        val count = countInput.toInt()

        return count
    }

}
