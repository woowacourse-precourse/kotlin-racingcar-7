package racingcar.control

import racingcar.view.CarNameError

class CarNameValidator {

    fun carNameValidator(carNameInput: String): List<String> {

        if (carNameInput.isBlank()) {
            throw IllegalArgumentException(CarNameError().carNameBlank)
        }
        if (carNameInput.all { it.toString() == SettingValue().delimiters }) {
            throw IllegalArgumentException(CarNameError().onlyDelimiters)
        }

        val carName = CarNameSeparator().carNameSeparator(carNameInput)

        for (i in carName) {
            if (i.length > SettingValue().maximumNumberOfCharacters) {
                throw IllegalArgumentException(CarNameError().carNameOverFive)
            }
        }
        if (!carNameInput.contains(SettingValue().delimiters) || carName.count() == 1) {
            throw IllegalArgumentException(CarNameError().notCompetitor)
        }
        return carName
    }
}