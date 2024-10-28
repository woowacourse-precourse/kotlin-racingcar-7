package racingcar.model

import racingcar.util.Validator

class CarList(private val input: List<String>) {
    private val _cars: List<Car> = input.map { Car(it) }

    val cars: List<Car>
        get() = _cars

    init {
        Validator.validateInput(input)
    }
}
