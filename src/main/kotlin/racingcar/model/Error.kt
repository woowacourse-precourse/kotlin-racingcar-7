package racingcar.model

import racingcar.constants.Constants.COMMA


private fun carNameNullError(carNames: String): Boolean {
    return carNames.isEmpty()
}

private fun carNameLengthError(carNames: String): Boolean {
    val carNameList = carNames.split(COMMA)

    for (i in carNameList.indices) {
        if (carNameList[i].length > 5) return true
    }
    return false
}

private fun sameCarNameError(carNames: String): Boolean {
    val carNameList = carNames.split(COMMA)

    for (i in carNameList.indices) {
        if (carNameList.count { it == carNameList[i] } > 1) return true
    }
    return false
}

fun carNameError(carNames: String): Boolean {

    return carNameNullError(carNames) || carNameLengthError(carNames)
            || sameCarNameError(carNames)
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
