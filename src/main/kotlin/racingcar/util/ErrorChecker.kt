package racingcar.util

import racingcar.util.Constant.BLANK
import racingcar.util.Constant.MAX_LENGTH

object ErrorChecker {
    fun checkValidCardName(carList: List<String>) {
        carList.forEach { carItem ->
            checkValidInput(carItem)
            checkCarNameLength(carItem)
        }
    }

    private fun checkCarNameLength(carItemName: String) {
        if (carItemName.length > MAX_LENGTH)
            throw IllegalArgumentException(ErrorType.CAR_NAME_LENGTH_OVER_FIVE_ERROR.errorMessage)
    }

    private fun checkValidInput(carItemName: String) {
        if (carItemName.contains(BLANK) || carItemName.isEmpty())
            throw IllegalArgumentException(ErrorType.CAR_NAME_BLANK_OR_INCLUDE_BLANK_ERROR.errorMessage)
    }
}
