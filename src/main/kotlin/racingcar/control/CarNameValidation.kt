package racingcar.control

import racingcar.message.InvalidCarNameException
import racingcar.utils.SettingValue


class CarNameValidation {
    fun validateCarName(carNameInput: String): String {
        if (carNameInput.isBlank()) {
            throw IllegalArgumentException(InvalidCarNameException.EMPTY_NAME)
        }
        if (carNameInput.all { it.toString() == " " }) {
            throw IllegalArgumentException(InvalidCarNameException.ONLY_GAP)
        }
        if (carNameInput.all { it.toString() == SettingValue.DELIMITER }) {
            throw IllegalArgumentException(InvalidCarNameException.DELIMITER_INPUT)
        }
        if (carNameInput.contains(",,")) {
            throw IllegalArgumentException(InvalidCarNameException.CONTINUOUS_DELIMITER)
        }
        if (carNameInput.startsWith(",") || carNameInput.endsWith(",")) {
            throw IllegalArgumentException(InvalidCarNameException.START_AND_END_DELIMITER_INPUT)
        }
        for (i in carNameInput.split(SettingValue.DELIMITER)) {
            if (i.all { it.toString() == " " }) {
                throw IllegalArgumentException(InvalidCarNameException.GAP_DELIMITER_INPUT)
            }
            if (i.length > SettingValue.MAXIMUM_NUMBER_OF_CHARACTERS) {
                throw IllegalArgumentException(InvalidCarNameException.EXCEEDED_CHARACTER_COUNT)
            }
        }
        if (!carNameInput.contains(SettingValue.DELIMITER) || carNameInput.split(SettingValue.DELIMITER).size == 1) {
            throw IllegalArgumentException(InvalidCarNameException.CANT_RACE_ALONE)
        }
        return carNameInput
    }
}
