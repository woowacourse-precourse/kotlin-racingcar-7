package racingcar.control

import racingcar.view.CarNameError


class CarNameValidator {

    fun carNameValidator(carNameInput: String): String {

        if (carNameInput.isBlank()) {
            throw IllegalArgumentException(CarNameError().EMPTY_NAME)
        }
        if (carNameInput.all { it.toString() == " " }) {
            throw IllegalArgumentException(CarNameError().ONLY_GAP)
        }
        if (carNameInput.all { it.toString() == SettingValue().DELIMITER }) {
            throw IllegalArgumentException(CarNameError().DELIMITER_INPUT)
        }
        if (carNameInput.contains(",,")) {
            throw IllegalArgumentException(CarNameError().CONTINUOUS_DELIMITER)
        }
        if (carNameInput.startsWith(",") || carNameInput.endsWith(",")) {
            throw IllegalArgumentException(CarNameError().START_AND_END_DELIMITER_INPUT)
        }
        for (i in carNameInput.split(SettingValue().DELIMITER)) {
            if (i.all { it.toString() == " " }) {
                throw IllegalArgumentException(CarNameError().GAP_DELIMITER_INPUT)
            }
            if (i.length > SettingValue().MAXIMUM_NUMBER_OF_CHARACTERS) {
                throw IllegalArgumentException(CarNameError().EXCEEDED_CHARACTER_COUNT_)
            }
        }
        if (carNameInput.contains(SettingValue().DELIMITER) && carNameInput.split(SettingValue().DELIMITER).size == 1) {
            throw IllegalArgumentException(CarNameError().CANT_RACE_ALONE)
        }
        return carNameInput
    }
}
