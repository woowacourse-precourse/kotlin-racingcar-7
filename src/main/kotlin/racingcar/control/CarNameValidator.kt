package racingcar.control

import racingcar.message.CarNameException
import racingcar.utils.SettingValue


class CarNameValidator {

    fun carNameValidator(carNameInput: String): String {

        if (carNameInput.isBlank()) {
            throw IllegalArgumentException(CarNameException().EMPTY_NAME)
        }
        if (carNameInput.all { it.toString() == " " }) {
            throw IllegalArgumentException(CarNameException().ONLY_GAP)
        }
        if (carNameInput.all { it.toString() == SettingValue().DELIMITER }) {
            throw IllegalArgumentException(CarNameException().DELIMITER_INPUT)
        }
        if (carNameInput.contains(",,")) {
            throw IllegalArgumentException(CarNameException().CONTINUOUS_DELIMITER)
        }
        if (carNameInput.startsWith(",") || carNameInput.endsWith(",")) {
            throw IllegalArgumentException(CarNameException().START_AND_END_DELIMITER_INPUT)
        }
        for (i in carNameInput.split(SettingValue().DELIMITER)) {
            if (i.all { it.toString() == " " }) {
                throw IllegalArgumentException(CarNameException().GAP_DELIMITER_INPUT)
            }
            if (i.length > SettingValue().MAXIMUM_NUMBER_OF_CHARACTERS) {
                throw IllegalArgumentException(CarNameException().EXCEEDED_CHARACTER_COUNT_)
            }
        }
        if (carNameInput.contains(SettingValue().DELIMITER) && carNameInput.split(SettingValue().DELIMITER).size == 1) {
            throw IllegalArgumentException(CarNameException().CANT_RACE_ALONE)
        }
        return carNameInput
    }
}
