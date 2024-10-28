package racingcar.validation

import racingcar.constant.Error.CAR_NAME_RANGE
import racingcar.constant.Error.NOT_VALID_CAR_NAME_LENGTH
import racingcar.constant.Error.NOT_VALID_ROUND_TYPE

class InputValidation {
    fun carName(name: String) =
        require(name.length in CAR_NAME_RANGE) { NOT_VALID_CAR_NAME_LENGTH.format(name, name.length) }

    fun raceRound(round: String) =
        round.toIntOrNull() ?: throw IllegalArgumentException(NOT_VALID_ROUND_TYPE.format(round))
}