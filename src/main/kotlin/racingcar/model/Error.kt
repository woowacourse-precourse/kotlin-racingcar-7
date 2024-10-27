package racingcar.model

import racingcar.constants.Constants.COMMA

class Error {
    private fun carNameNullError(carNames: String): Boolean {
        return carNames.isEmpty()
    }

    private fun carNameLengthError(carNames: String): Boolean {
        val carNameList = carNames.split(COMMA)

        carNameList.forEach { carName ->
            if (carName.length > 5) return true
        }
        return false
    }

    private fun sameCarNameError(carNames: String): Boolean {
        val carNameList = carNames.split(COMMA)

        carNameList.forEach { carName ->
            if (carNameList.count { it == carName } > 1) return true
        }
        return false
    }

    fun carNameError(carNames: String): Boolean {

        return carNameNullError(carNames) || carNameLengthError(carNames) || sameCarNameError(carNames)
    }

    private fun notNumberError(tryCount: String): Boolean {
        try {
            tryCount.toInt()
        } catch (e: Exception) {
            return true
        }

        return false
    }

    private fun negativeNumberError(tryCount: String): Boolean {
        return tryCount.toInt() <= 0
    }

    fun tryCountError(tryCount: String): Boolean {
        return notNumberError(tryCount) || negativeNumberError(tryCount)
    }
}
