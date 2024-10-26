package racingcar.control

import racingcar.view.CarNameError

class CarNameValidator {

    fun carNameValidator(carNameInput: String): List<String> {

        if (carNameInput.isBlank()) {
            throw IllegalArgumentException(CarNameError().carNameBlank)
        }
        val carName: List<String> = carNameInput.split(",")
        for (i in carName) {
            if (i.length > 5) {
                throw IllegalArgumentException(CarNameError().carNameOverFive)
            }
        }
        return carName
    }
}