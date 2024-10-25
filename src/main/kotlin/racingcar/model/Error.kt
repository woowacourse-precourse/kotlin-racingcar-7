package racingcar.model


private fun carNameNullError(carNames: String): Boolean {
    return carNames.isEmpty()
}

fun carNameError(carNames: String): Boolean {
    if (carNameNullError(carNames)) return true

    val carNameList = carNames.split(',')
    if (carNameList.isEmpty()) return true

    for (i in carNameList.indices) {
        if (carNameList[i].length > 5) return true
    }

    return false
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

