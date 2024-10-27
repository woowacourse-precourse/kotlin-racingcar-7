package racingcar.util

import racingcar.util.Constant.BLANK
import racingcar.util.Constant.MAX_LENGTH
import racingcar.util.Constant.ZERO

object ErrorChecker {
    fun checkValidCardName(carList: List<String>) {
        carList.forEach { carItem ->
            checkValidInput(carItem)
            checkCarNameLength(carItem)
        }
    }

    fun checkValidTryNumber(tryNumber: String) {
        checkNumberType(tryNumber)
        checkNumberLength(tryNumber.toInt())
    }

    private fun checkCarNameLength(carItemName: String) {
        if (carItemName.length > MAX_LENGTH)
            throw IllegalArgumentException(ErrorType.CAR_NAME_LENGTH_OVER_FIVE_ERROR.errorMessage)
    }

    private fun checkValidInput(carItemName: String) {
        if (carItemName.contains(BLANK) || carItemName.isEmpty())
            throw IllegalArgumentException(ErrorType.CAR_NAME_BLANK_OR_INCLUDE_BLANK_ERROR.errorMessage)
    }

    private fun checkNumberType(tryNumber: String) {
        if (tryNumber.toIntOrNull() == null)
            throw IllegalArgumentException(ErrorType.TRY_NUMBER_NOT_INT_TYPE_ERROR.errorMessage)
    }

    private fun checkNumberLength(tryNumber: Int) {
        if (tryNumber <= ZERO)
            throw IllegalArgumentException(ErrorType.TRY_NUMBER_UNDER_ZERO_ERROR.errorMessage)
    }
}
