package racingcar.control

import racingcar.userInput.CarNameInput

class Car {
    fun car(): List<String> {
        val carNameInput = CarNameInput().carNameInput()
        val car: List<String> = carNameInput.split(",")
    return car
    }
}