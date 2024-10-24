package racingcar.model

class Error(private val carNames: String, private val tryCount: String) {

    private fun carNameNullError(): Boolean {
        return carNames.isEmpty()
    }

    private fun carNameError(): Boolean {
        if (carNameNullError()) return true

        val carNameList = carNames.split(',')
        if (carNameList.isEmpty()) return true

        for (i in carNameList.indices) {
            if (carNameList[i].length > 5) return true
        }

        return false
    }

    private fun notNumberError(): Boolean {
        try {
            tryCount.toInt()
        } catch (e: Exception) {
            return true
        }

        return false
    }

    private fun negativeNumberError(): Boolean {
        return tryCount.toInt() <= 0
    }

    fun totalError(): Boolean {
        return carNameError() || notNumberError() || negativeNumberError()
    }
}
