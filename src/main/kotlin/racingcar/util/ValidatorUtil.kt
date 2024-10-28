package racingcar.util

import racingcar.util.ConstantsUtil.CAR_NAME_MAX_LENGTH
import racingcar.util.ConstantsUtil.MESSAGE_CAR_LENGTH_EXCEEDED
import racingcar.util.ConstantsUtil.MESSAGE_CAR_NAME_BLANK
import racingcar.util.ConstantsUtil.MESSAGE_CAR_NAME_DUPLICATE
import racingcar.util.ConstantsUtil.MESSAGE_ROUND_NOT_EXCEEDED
import racingcar.util.ConstantsUtil.MESSAGE_ROUND_NOT_INT

object ValidatorUtil {

    fun validateCarLength(carLength: Int) {
        require(carLength <= CAR_NAME_MAX_LENGTH){
            MESSAGE_CAR_LENGTH_EXCEEDED
        }
    }

    fun validateCarName(carName: String) {
        require(carName.isNotBlank()) {
            MESSAGE_CAR_NAME_BLANK
        }
    }

    fun validateCarsNames(carNames: List<String>) {
        require(carNames.size == carNames.distinct().size){
            MESSAGE_CAR_NAME_DUPLICATE
        }
    }

    fun validateRoundType(roundString: String) {
        require(roundString.toIntOrNull() != null){
            MESSAGE_ROUND_NOT_INT
        }
    }

    fun validateRoundRange(roundNumber: Int){
        require(roundNumber >= 1){
            MESSAGE_ROUND_NOT_EXCEEDED
        }
    }
}